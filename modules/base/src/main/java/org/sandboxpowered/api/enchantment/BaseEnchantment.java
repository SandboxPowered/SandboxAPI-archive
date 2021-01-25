package org.sandboxpowered.api.enchantment;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Alpha;

@Alpha
public abstract class BaseEnchantment implements Enchantment {
    private final int minLevel;
    private final int maxLevel;
    private final boolean curse;
    private final boolean treasure;
    private final Rarity rarity;
    private Identity identity;

    public BaseEnchantment(int minLevel, int maxLevel, boolean curse, boolean treasure, Rarity rarity) {
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.curse = curse;
        this.treasure = treasure;
        this.rarity = rarity;
    }

    @Override
    public Identity getIdentity() {
        return identity;
    }

    @Override
    public Enchantment setIdentity(Identity identity) {
        if (this.identity != null)
            throw new UnsupportedOperationException("Cannot set identity on content with existing identity");
        this.identity = identity;
        return this;
    }

    @Override
    public int getMinimumLevel() {
        return minLevel;
    }

    @Override
    public int getMaximumLevel() {
        return maxLevel;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isCurse() {
        return curse;
    }

    @Override
    public boolean isTreasure() {
        return treasure;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }
}
