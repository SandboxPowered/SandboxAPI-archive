package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.block.BaseBlock;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Material;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.item.BaseItem;
import org.sandboxpowered.api.item.Item;

import java.util.function.Function;

public final class ResourceConstants {

    private static final Function<ResourceMaterial, Item> ITEM_CREATOR = material -> new BaseItem(new Item.Settings());

    public static ResourceMaterial CLAY = ResourceMaterial.of("clay");
    public static ResourceMaterial WOOD = ResourceMaterial.of("wood");
    public static ResourceMaterial COAL = ResourceMaterial.of("coal");
    public static ResourceMaterial IRON = ResourceMaterial.of("iron");
    public static ResourceMaterial GOLD = ResourceMaterial.of("gold");
    public static ResourceMaterial LAPIS = ResourceMaterial.of("lapis");
    public static ResourceMaterial REDSTONE = ResourceMaterial.of("redstone");
    public static ResourceMaterial DIAMOND = ResourceMaterial.of("diamond");
    public static ResourceMaterial EMERALD = ResourceMaterial.of("emerald");
    public static ResourceMaterial OBSIDIAN = ResourceMaterial.of("obsidian");
    public static ResourceMaterial QUARTZ = ResourceMaterial.of("quartz");
    public static ResourceMaterial GLOWSTONE = ResourceMaterial.of("glowstone");
    public static ResourceMaterial NETHERITE = ResourceMaterial.of("netherite");

    public static ResourceType<Item> INGOT = ResourceType.of("ingot", ITEM_CREATOR);
    public static ResourceType<Item> DUST = ResourceType.of("dust", ITEM_CREATOR);
    public static ResourceType<Item> NUGGET = ResourceType.of("nugget", ITEM_CREATOR);
    public static ResourceType<Item> GEM = ResourceType.of("gem", ITEM_CREATOR);
    public static ResourceType<Block> ORE = ResourceType.of("ore", m -> new BaseBlock(Block.Settings.builder(Material.STONE).build()));
    public static ResourceType<Block> BLOCK = ResourceType.of("block", m -> new BaseBlock(Block.Settings.builder(Material.METAL).build()));

    public static ResourceType<?>[] METAL = new ResourceType[]{INGOT, DUST, NUGGET, ORE, BLOCK};

    public static ResourceMaterial material(String name) {
        return ResourceMaterial.of(name);
    }

    public static <C extends Content<C>> ResourceType<C> type(String name, Function<ResourceMaterial, C> defaultCreator) {
        return ResourceType.of(name, defaultCreator);
    }

    public static ResourceType<Item> type(String name) {
        return ResourceType.of(name, ITEM_CREATOR);
    }
}