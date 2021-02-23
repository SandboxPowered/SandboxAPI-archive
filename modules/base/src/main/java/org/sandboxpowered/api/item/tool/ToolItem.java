package org.sandboxpowered.api.item.tool;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import org.sandboxpowered.api.item.BaseItem;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.item.attribute.Attribute;
import org.sandboxpowered.api.item.attribute.Attributes;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.EquipmentSlot;
import org.sandboxpowered.api.util.InteractionResult;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;

import java.util.UUID;

public class ToolItem extends BaseItem {
    protected static final UUID BASE_ATTACK_DAMAGE_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    protected static final UUID BASE_ATTACK_SPEED_UUID = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");

    private final ToolMaterial material;
    private final Multimap<Attribute, Attribute.Modifier> defaultModifiers;
    private final float baseAttackDamage;

    public ToolItem(ToolMaterial material, float attackDamageIn, float attackSpeedIn, Settings settings) {
        super(settings.setDefaultDurability(material.getDurability()));
        this.material = material;
        this.baseAttackDamage = attackDamageIn + material.getAttackDamage();
        ImmutableMultimap.Builder<Attribute, Attribute.Modifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, Attribute.modifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", baseAttackDamage, Attribute.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, Attribute.modifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeedIn, Attribute.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public ToolMaterial getToolMaterial() {
        return material;
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        return isEffectiveOn(stack, state) ? material.getDigSpeed() : 1;
    }

    @Override
    public boolean isEffectiveOn(ItemStack stack, BlockState state) {
        ToolType type = state.getHarvestTool();
        if (type == null)
            return false;
        int level = getSettings().getToolLevel(type);
        return level >= 0;
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        ToolType type = state.getHarvestTool();
        if (type == null)
            return false;
        int level = getSettings().getToolLevel(type);
        return level >= state.getHarvestLevel();
    }

    @Override
    public InteractionResult onItemUsed(World world, Position position, ItemStack itemStack) {
        int level = getSettings().getToolLevel(ToolType.STRIPPER);
        if (level > -1) {
            //TODO: implement log stripping
            return InteractionResult.SUCCESS;
        }

        level = getSettings().getToolLevel(ToolType.PAVER);
        if (level > -1) {
            //TODO: implement grass paving
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.IGNORE;
    }

    @Override
    public boolean onMine(ItemStack stack, World world, Position pos, BlockState state, int user) {
        if (world.isServer() && state.getDestroySpeed(world, pos) != 0f) {
            stack.damage(1, world, user);
        }
        return true;
    }

    @Override
    public float getAttackDamage(ItemStack stack) {
        return baseAttackDamage;
    }

    @Override
    public int getEnchantmentValue() {
        return getToolMaterial().getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairStack(ItemStack tool, ItemStack ingredient) {
        return getToolMaterial().getRepairIngredient().test(ingredient);
    }

    @Override
    public Multimap<Attribute, Attribute.Modifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAIN_HAND ? defaultModifiers : super.getAttributeModifiers(slot);
    }
}