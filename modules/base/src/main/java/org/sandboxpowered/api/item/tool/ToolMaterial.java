package org.sandboxpowered.api.item.tool;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.recipe.Ingredient;

public interface ToolMaterial {
    int getDurability();

    float getDigSpeed();

    float getAttackDamage();

    int getMiningLevel();

    int getEnchantmentValue();

    Ingredient<ItemStack> getRepairIngredient();
}
