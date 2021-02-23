package org.sandboxpowered.api.block;

import org.sandboxpowered.api.inject.Sandbox;

public final class Materials {
    public static final Material AIR = get("AIR");
    public static final Material STRUCTURE_VOID = get("STRUCTURE_VOID");
    public static final Material PORTAL = get("PORTAL");
    public static final Material CARPET = get("CARPET");
    public static final Material PLANT = get("PLANT");
    public static final Material UNDERWATER_PLANT = get("UNDERWATER_PLANT");
    public static final Material REPLACEABLE_PLANT = get("REPLACEABLE_PLANT");
    public static final Material SEAGRASS = get("SEAGRASS");
    public static final Material WATER = get("WATER");
    public static final Material BUBBLE_COLUMN = get("BUBBLE_COLUMN");
    public static final Material LAVA = get("LAVA");
    public static final Material SNOW = get("SNOW");
    public static final Material FIRE = get("FIRE");
    public static final Material PART = get("PART");
    public static final Material COBWEB = get("COBWEB");
    public static final Material REDSTONE_LAMP = get("REDSTONE_LAMP");
    public static final Material CLAY = get("CLAY");
    public static final Material EARTH = get("EARTH");
    public static final Material ORGANIC = get("ORGANIC");
    public static final Material PACKED_ICE = get("PACKED_ICE");
    public static final Material SAND = get("SAND");
    public static final Material SPONGE = get("SPONGE");
    public static final Material SHULKER_BOX = get("SHULKER_BOX");
    public static final Material WOOD = get("WOOD");
    public static final Material BAMBOO_SAPLING = get("BAMBOO_SAPLING");
    public static final Material BAMBOO = get("BAMBOO");
    public static final Material WOOL = get("WOOL");
    public static final Material TNT = get("TNT");
    public static final Material LEAVES = get("LEAVES");
    public static final Material GLASS = get("GLASS");
    public static final Material ICE = get("ICE");
    public static final Material CACTUS = get("CACTUS");
    public static final Material STONE = get("STONE");
    public static final Material METAL = get("METAL");
    public static final Material SNOW_BLOCK = get("SNOW_BLOCK");
    public static final Material HEAVY_METAL = get("HEAVY_METAL");
    public static final Material BARRIER = get("BARRIER");
    public static final Material PISTON = get("PISTON");
    public static final Material UNUSED_PLANT = get("UNUSED_PLANT");
    public static final Material PUMPKIN = get("PUMPKIN");
    public static final Material EGG = get("EGG");
    public static final Material CAKE = get("CAKE");

    private static Material get(String mat) {
        return Sandbox.getFactoryProvider().get(Factory.class).get(mat);
    }

    public interface Factory {
        Material get(String s);
    }
}
