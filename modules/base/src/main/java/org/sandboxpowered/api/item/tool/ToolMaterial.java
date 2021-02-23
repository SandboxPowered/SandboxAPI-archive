package org.sandboxpowered.api.item.tool;

import org.jetbrains.annotations.Range;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.recipe.Ingredient;

public interface ToolMaterial {
    @Range(from = 0, to = Integer.MAX_VALUE)
    int getDurability();

    float getDigSpeed();

    float getAttackDamage();

    @Range(from = 0, to = Integer.MAX_VALUE)
    int getMiningLevel();

    @Range(from = 0, to = Integer.MAX_VALUE)
    int getEnchantmentValue();

    Ingredient<ItemStack> getRepairIngredient();
}
