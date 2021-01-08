package org.sandboxpowered.api.enchantment;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.annotation.Beta;
import org.sandboxpowered.api.world.World;

@Beta
public interface Enchantment extends Content<Enchantment> {
    Registry<Enchantment> REGISTRY = Registry.getRegistryFromType(Enchantment.class);

    int getMinimumLevel();

    int getMaximumLevel();

    boolean isAcceptableItem(ItemStack stack);

    boolean isCurse();

    boolean isTreasure();

    Rarity getRarity();

    default void onTargetDamage(World world, int self, int victim, int level) {
    }

    default void onUserDamage(World world, int self, int attacker, int level) {
    }

    @Override
    default Class<Enchantment> getContentType() {
        return Enchantment.class;
    }

    enum Rarity {
        COMMON(10),
        UNCOMMON(5),
        RARE(2),
        VERY_RARE(1);

        private final int weight;

        Rarity(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }
}