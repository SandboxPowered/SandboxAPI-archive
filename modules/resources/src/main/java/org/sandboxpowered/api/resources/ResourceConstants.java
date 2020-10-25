package org.sandboxpowered.api.resources;

public final class ResourceConstants {
    public static ResourceMaterial WOOD = ResourceMaterial.of("wood");
    public static ResourceMaterial COAL = ResourceMaterial.of("coal");
    public static ResourceMaterial IRON = ResourceMaterial.of("iron");
    public static ResourceMaterial GOLD = ResourceMaterial.of("gold");
    public static ResourceMaterial LAPIS = ResourceMaterial.of("lapis");
    public static ResourceMaterial REDSTONE = ResourceMaterial.of("redstone");
    public static ResourceMaterial DIAMOND = ResourceMaterial.of("diamond");
    public static ResourceMaterial EMERALD = ResourceMaterial.of("emerald");
    public static ResourceMaterial QUARTZ = ResourceMaterial.of("quartz");
    public static ResourceMaterial NETHERITE = ResourceMaterial.of("netherite");

    public static ResourceType ORE = ResourceType.of("ore");
    public static ResourceType INGOT = ResourceType.of("ingot");
    public static ResourceType DUST = ResourceType.of("dust");
    public static ResourceType NUGGET = ResourceType.of("nugget");
    public static ResourceType GEM = ResourceType.of("gem");
    public static ResourceType BLOCK = ResourceType.of("block");

    public static ResourceType[] METAL_ITEM = new ResourceType[]{INGOT, DUST, NUGGET};
    public static ResourceType[] METAL_BLOCK = new ResourceType[]{ORE, BLOCK};

    public static ResourceMaterial material(String name) {
        return ResourceMaterial.of(name);
    }

    public static ResourceType type(String name) {
        return ResourceType.of(name);
    }
}