package org.sandboxpowered.api.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import org.sandboxpowered.api.capability.Capability;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.item.attribute.Attribute;
import org.sandboxpowered.api.item.tool.ToolMaterial;
import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.EquipmentSlot;
import org.sandboxpowered.api.util.InteractionResult;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.math.Maths;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.text.Text;
import org.sandboxpowered.api.world.World;

import java.util.*;

public interface Item extends Content<Item> {
    Registry<Item> REGISTRY = Registry.getRegistryFromType(Item.class);

    default InteractionResult onItemUsed(World world, Position position, ItemStack itemStack) {
        return InteractionResult.IGNORE;
    }

    @Override
    default Class<Item> getContentType() {
        return Item.class;
    }

    Settings getSettings();

    default void appendTooltipText(ItemStack cast, @Nullable World world, List<Text> tooltip, boolean advanced) {

    }

    default float getMiningSpeed(ItemStack stack, BlockState state) {
        return 1;
    }

    default boolean isEffectiveOn(ItemStack stack, BlockState state) {
        return false;
    }

    default boolean isCorrectToolForDrops(BlockState state) {
        return false;
    }

    default boolean onHit(ItemStack stack, World world, int attacker, int victim) {
        return false;
    }

    default boolean onMine(ItemStack stack, World world, Position pos, BlockState state, int user) {
        return false;
    }

    default CompoundTag writeSyncTag(ItemStack stack) {
        return stack.getTag();
    }

    default void readSyncTag(ItemStack stack, CompoundTag tag) {
        stack.setTag(tag);
    }

    default <X> Mono<X> getCapability(Capability<X> capability) {
        return getCapability(capability, ItemStack.empty());
    }

    default <X> Mono<X> getCapability(Capability<X> capability, ItemStack stack) {
        return Mono.empty();
    }

    default boolean showEnchantmentGlint(ItemStack stack) {
        return stack.isEnchanted();
    }

    default boolean showDurabilityBar(ItemStack stack) {
        return stack.isDamageable() && stack.isDamaged();
    }

    default float getDurabilityBarValue(ItemStack stack) {
        if (!stack.isDamageable())
            return 0;
        return 1 - stack.getDamage() / (float)stack.getMaxDamage();
    }

    default int getDurabilityBarColor(ItemStack stack) {
        if (!stack.isDamageable())
            return -1;
        float hue = (stack.getMaxDamage() - stack.getDamage()) / (float) stack.getMaxDamage();
        return Maths.hsvToRgb(hue / 3f, 1f, 1f);
    }

    default boolean shouldRenderStackCount(ItemStack stack) {
        return stack.getCount() != 1;
    }

    default float getAttackDamage(ItemStack stack) {
        return 1;
    }

    default Multimap<Attribute, Attribute.Modifier> getAttributeModifiers(EquipmentSlot slot) {
        return ImmutableMultimap.of();
    }

    @Range(from = 0, to = Integer.MAX_VALUE)
    default int getEnchantmentValue() {
        return 0;
    }

    default Set<ToolType> getToolTypes(ItemStack stack) {
        return Collections.emptySet();
    }

    default boolean isValidRepairStack(ItemStack tool, ItemStack ingredient) {
        return false;
    }

    class Settings {
        private int stackSize = 64;
        private int durability;
        @Nullable
        private Item recipeRemainder;
        private final Map<ToolType,Integer> toolTypes = new HashMap<>();

        public int getDurability() {
            return durability;
        }

        public Settings setDurability(int durability) {
            this.durability = durability;
            this.stackSize = 1;
            return this;
        }

        public Settings setDefaultDurability(int durability) {
            return this.durability == 0 ? setDurability(durability) : this;
        }

        public int getStackSize() {
            return stackSize;
        }

        public Settings setStackSize(int stackSize) {
            if (this.durability > 0) {
                throw new UnsupportedOperationException("Unable to have damage AND stack.");
            } else {
                this.stackSize = stackSize;
                return this;
            }
        }

        public Settings addToolType(ToolType type, int level) {
            toolTypes.put(type, level);
            return this;
        }

        public Settings addToolType(ToolType type, ToolMaterial material) {
            toolTypes.put(type, material.getMiningLevel());
            return this;
        }

        public Settings addToolTypes(ToolMaterial material, ToolType... types) {
            for (ToolType type : types) {
                toolTypes.put(type, material.getMiningLevel());
            }
            return this;
        }

        public Settings addToolTypes(int level, ToolType... types) {
            for (ToolType type : types) {
                toolTypes.put(type, level);
            }
            return this;
        }

        @Range(from = -1, to = Integer.MAX_VALUE)
        public int getToolLevel(ToolType type) {
            return toolTypes.getOrDefault(type, -1);
        }

        @Nullable
        public Item getRecipeRemainder() {
            return recipeRemainder;
        }

        public Settings setRecipeRemainder(@Nullable Item recipeRemainder) {
            this.recipeRemainder = recipeRemainder;
            return this;
        }

        public Set<ToolType> getToolTypes() {
            return toolTypes.keySet();
        }
    }
}