package org.sandboxpowered.api.tags;

import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.internal.InternalService;

public class BlockTags {
    public static final Tag<Block> WOOL = getTag("wool");
    public static final Tag<Block> PLANKS = getTag("planks");
    public static final Tag<Block> STONE_BRICKS = getTag("stone_bricks");
    public static final Tag<Block> WOODEN_BUTTONS = getTag("wooden_buttons");
    public static final Tag<Block> BUTTONS = getTag("buttons");
    public static final Tag<Block> CARPETS = getTag("carpets");
    public static final Tag<Block> WOODEN_DOORS = getTag("wooden_doors");
    public static final Tag<Block> WOODEN_STAIRS = getTag("wooden_stairs");
    public static final Tag<Block> WOODEN_SLABS = getTag("wooden_slabs");
    public static final Tag<Block> WOODEN_FENCES = getTag("wooden_fences");
    public static final Tag<Block> PRESSURE_PLATES = getTag("pressure_plates");
    public static final Tag<Block> WOODEN_PRESSURE_PLATES = getTag("wooden_pressure_plates");
    public static final Tag<Block> STONE_PRESSURE_PLATES = getTag("stone_pressure_plates");
    public static final Tag<Block> WOODEN_TRAPDOORS = getTag("wooden_trapdoors");
    public static final Tag<Block> DOORS = getTag("doors");
    public static final Tag<Block> SAPLINGS = getTag("saplings");
    public static final Tag<Block> LOGS_THAT_BURN = getTag("logs_that_burn");
    public static final Tag<Block> LOGS = getTag("logs");
    public static final Tag<Block> DARK_OAK_LOGS = getTag("dark_oak_logs");
    public static final Tag<Block> OAK_LOGS = getTag("oak_logs");
    public static final Tag<Block> BIRCH_LOGS = getTag("birch_logs");
    public static final Tag<Block> ACACIA_LOGS = getTag("acacia_logs");
    public static final Tag<Block> JUNGLE_LOGS = getTag("jungle_logs");
    public static final Tag<Block> SPRUCE_LOGS = getTag("spruce_logs");
    public static final Tag<Block> CRIMSON_STEMS = getTag("crimson_stems");
    public static final Tag<Block> WARPED_STEMS = getTag("warped_stems");
    public static final Tag<Block> BANNERS = getTag("banners");
    public static final Tag<Block> SAND = getTag("sand");
    public static final Tag<Block> STAIRS = getTag("stairs");
    public static final Tag<Block> SLABS = getTag("slabs");
    public static final Tag<Block> WALLS = getTag("walls");
    public static final Tag<Block> ANVIL = getTag("anvil");
    public static final Tag<Block> RAILS = getTag("rails");
    public static final Tag<Block> LEAVES = getTag("leaves");
    public static final Tag<Block> TRAPDOORS = getTag("trapdoors");
    public static final Tag<Block> SMALL_FLOWERS = getTag("small_flowers");
    public static final Tag<Block> BEDS = getTag("beds");
    public static final Tag<Block> FENCES = getTag("fences");
    public static final Tag<Block> TALL_FLOWERS = getTag("tall_flowers");
    public static final Tag<Block> FLOWERS = getTag("flowers");
    public static final Tag<Block> PIGLIN_REPELLENTS = getTag("piglin_repellents");
    public static final Tag<Block> GOLD_ORES = getTag("gold_ores");
    public static final Tag<Block> NON_FLAMMABLE_WOOD = getTag("non_flammable_wood");
    public static final Tag<Block> FLOWER_POTS = getTag("flower_pots");
    public static final Tag<Block> ENDERMAN_HOLDABLE = getTag("enderman_holdable");
    public static final Tag<Block> ICE = getTag("ice");
    public static final Tag<Block> VALID_SPAWN = getTag("valid_spawn");
    public static final Tag<Block> IMPERMEABLE = getTag("impermeable");
    public static final Tag<Block> UNDERWATER_BONEMEALS = getTag("underwater_bonemeals");
    public static final Tag<Block> CORAL_BLOCKS = getTag("coral_blocks");
    public static final Tag<Block> WALL_CORALS = getTag("wall_corals");
    public static final Tag<Block> CORAL_PLANTS = getTag("coral_plants");
    public static final Tag<Block> CORALS = getTag("corals");
    public static final Tag<Block> BAMBOO_PLANTABLE_ON = getTag("bamboo_plantable_on");
    public static final Tag<Block> STANDING_SIGNS = getTag("standing_signs");
    public static final Tag<Block> WALL_SIGNS = getTag("wall_signs");
    public static final Tag<Block> SIGNS = getTag("signs");
    public static final Tag<Block> DRAGON_IMMUNE = getTag("dragon_immune");
    public static final Tag<Block> WITHER_IMMUNE = getTag("wither_immune");
    public static final Tag<Block> WITHER_SUMMON_BASE_BLOCKS = getTag("wither_summon_base_blocks");
    public static final Tag<Block> BEEHIVES = getTag("beehives");
    public static final Tag<Block> CROPS = getTag("crops");
    public static final Tag<Block> BEE_GROWABLES = getTag("bee_growables");
    public static final Tag<Block> PORTALS = getTag("portals");
    public static final Tag<Block> FIRE = getTag("fire");
    public static final Tag<Block> NYLIUM = getTag("nylium");
    public static final Tag<Block> WART_BLOCKS = getTag("wart_blocks");
    public static final Tag<Block> BEACON_BASE_BLOCKS = getTag("beacon_base_blocks");
    public static final Tag<Block> SOUL_SPEED_BLOCKS = getTag("soul_speed_blocks");
    public static final Tag<Block> WALL_POST_OVERRIDE = getTag("wall_post_override");
    public static final Tag<Block> CLIMBABLE = getTag("climbable");
    public static final Tag<Block> SHULKER_BOXES = getTag("shulker_boxes");
    public static final Tag<Block> HOGLIN_REPELLENTS = getTag("hoglin_repellents");
    public static final Tag<Block> SOUL_FIRE_BASE_BLOCKS = getTag("soul_fire_base_blocks");
    public static final Tag<Block> STRIDER_WARM_BLOCKS = getTag("strider_warm_blocks");
    public static final Tag<Block> CAMPFIRES = getTag("campfires");
    public static final Tag<Block> GUARDED_BY_PIGLINS = getTag("guarded_by_piglins");
    public static final Tag<Block> PREVENT_MOB_SPAWNING_INSIDE = getTag("prevent_mob_spawning_inside");
    public static final Tag<Block> FENCE_GATES = getTag("fence_gates");
    public static final Tag<Block> UNSTABLE_BOTTOM_CENTER = getTag("unstable_bottom_center");
    public static final Tag<Block> MUSHROOM_GROW_BLOCK = getTag("mushroom_grow_block");
    public static final Tag<Block> INFINIBURN_OVERWORLD = getTag("infiniburn_overworld");
    public static final Tag<Block> INFINIBURN_NETHER = getTag("infiniburn_nether");
    public static final Tag<Block> INFINIBURN_END = getTag("infiniburn_end");
    public static final Tag<Block> BASE_STONE_OVERWORLD = getTag("base_stone_overworld");
    public static final Tag<Block> BASE_STONE_NETHER = getTag("base_stone_nether");

    @NotNull
    private static Tag<Block> getTag(String string) {
        return InternalService.getInstance().getBlockTag(string);
    }
}
