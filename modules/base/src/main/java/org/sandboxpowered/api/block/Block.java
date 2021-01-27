package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.capability.Capability;
import org.sandboxpowered.api.client.GraphicsMode;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.ecs.Entity;
import org.sandboxpowered.api.ecs.EntityBlueprint;
import org.sandboxpowered.api.fluid.Fluids;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemProvider;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.FluidState;
import org.sandboxpowered.api.state.Properties;
import org.sandboxpowered.api.state.StateFactory;
import org.sandboxpowered.api.util.*;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.util.math.Vec3f;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.WorldReader;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface Block extends ItemProvider, Content<Block> {
    Registry<Block> REGISTRY = Registry.getRegistryFromType(Block.class);

    @Override
    default Class<Block> getContentType() {
        return Block.class;
    }

    /**
     * The {@link Settings} assigned to the Block
     */
    Settings getSettings();

    /**
     * Grabs the Block as an {@link Item}
     */
    @Override
    Optional<Item> asItem();

    default <X> Mono<X> getCapability(WorldReader world, Position position, BlockState state, Capability<X> capability) {
        return getCapability(world, position, state, capability, null);
    }

    default <X> Mono<X> getCapability(WorldReader world, Position position, BlockState state, Capability<X> capability, @Nullable Direction side) {
        return Mono.empty();
    }

    /**
     * Gets called when the block is interacted with by a Player
     *
     * @return The {@link InteractionResult} of the interaction
     */
    default InteractionResult onBlockUsed(World world, Position pos, BlockState state, Entity player, Hand hand, Direction side, Vec3f hit) {
        return InteractionResult.IGNORE;
    }

    /**
     * Gets called when the block is clicked by a Player
     */
    default void onBlockClicked(World world, Position pos, BlockState state, Entity player) {

    }

    default BlockState getStateForPlacement(WorldReader reader, Position pos, Entity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        return getBaseState();
    }

    default boolean isSame(Block block) {
        return this == block;
    }

    BlockState getBaseState();

    StateFactory<Block, BlockState> getStateFactory();

    default Shape getShape(WorldReader reader, Position position, BlockState state) {
        return Shape.fullCube();
    }

    default Shape getCollisionShape(WorldReader reader, Position position, BlockState state) {
        return getShape(reader, position, state);
    }

    default Shape getOcclusionShape(WorldReader reader, Position position, BlockState state) {
        return getShape(reader, position, state);
    }

    /**
     * Gets called when the block is placed
     */
    default void onBlockPlaced(World world, Position position, BlockState state, Entity entity, ItemStack itemStack) {
    }

    /**
     * Gets called when the block is broken
     */
    default void onBlockBroken(World world, Position position, BlockState state) {
    }

    /**
     * Updates the {@link BlockState} when a neighbor block updates
     *
     * @return The {@link BlockState} to set in the world
     */
    default BlockState updateOnNeighborChanged(BlockState state, Direction direction, BlockState otherState, World world, Position position, Position otherPosition) {
        return state;
    }

    default void randomTick(World serverWorld, Position position, BlockState blockState, Random random) {
    }

    /**
     * Creates a blueprint used for all block entities belonging to this block
     * <p>
     * Make sure to set {@link Block.Settings.Builder#hasBlockEntity()} to use this
     */
    @Nullable
    default EntityBlueprint createBlockEntityBlueprint(WorldReader reader) {
        return null;
    }

    default BlockState rotate(BlockState state, Rotation rotation) {
        return state;
    }

    default BlockState mirror(BlockState state, Mirror mirror) {
        return state;
    }

    default boolean canReplace(WorldReader reader, Position pos, BlockState currentState, Entity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        return getMaterial(currentState).isReplaceable();
    }

    default boolean isAir(BlockState state) {
        return false;
    }

    default void onEntityWalk(World world, Position position, Entity entity) {
    }

    default boolean canEntitySpawnWithin(BlockState state) {
        return !getMaterial(state).isSolid() && !getMaterial(state).isLiquid();
    }

    default Material.PistonInteraction getPistonInteraction(BlockState state) {
        return getMaterial(state).getPistonInteraction();
    }

    default boolean emitsRedstone(BlockState state) {
        return false;
    }

    default boolean hasComparatorValue(BlockState state) {
        return false;
    }

    default int getComparatorValue(WorldReader world, Position pos, BlockState state) {
        return 0;
    }

    default int getWeakPower(WorldReader blockView, Position pos, BlockState state, Direction direction) {
        return 0;
    }

    default int getStrongPower(WorldReader blockView, Position pos, BlockState state, Direction direction) {
        return 0;
    }

    default Material getMaterial(BlockState state) {
        return getSettings().getMaterial();
    }

    default float getHardness(BlockState state) {
        return getSettings().getHardness();
    }

    default float getResistance(BlockState state) {
        return getSettings().getResistance();
    }

    default float getSlipperiness(BlockState state) {
        return getSettings().getSlipperiness();
    }

    default float getVelocity(BlockState state) {
        return getSettings().getVelocity();
    }

    default float getJumpVelocity(BlockState state) {
        return getSettings().getJumpVelocity();
    }

    default int getLuminance(BlockState state) {
        return getSettings().getLuminance();
    }

    default ItemStack getPickStack(WorldReader reader, Position position, BlockState state) {
        return ItemStack.of(this);
    }

    default BlockRenderLayer getRenderLayer(BlockState state, GraphicsMode mode) {
        return BlockRenderLayer.SOLID;
    }

    default RenderType getRenderType() {
        return RenderType.MODEL;
    }

    default List<ItemStack> getDrops(World world, Position position, BlockState state) {
        return Collections.emptyList();
    }

    default FluidState getFluidState(BlockState state) {
        if (state.contains(Properties.WATERLOGGED) && state.get(Properties.WATERLOGGED)) {
            return Fluids.WATER.get().getBaseState();
        }
        return Fluids.EMPTY.get().getBaseState();
    }

    enum BlockRenderLayer {
        SOLID,
        CUTOUT,
        CUTOUT_MIPPED,
        TRANSPARENT
    }

    enum RenderType {
        MODEL,
        DYNAMIC,
        INVISIBLE
    }

    //TODO: mining tool/level, map color, collision, opacity, sound group, random tick, drops, dynamic bounds
    class Settings {
        private final Material material;
        private final float hardness;
        private final float resistance;
        private final float slipperiness;
        private final float velocity;
        private final float jumpVelocity;
        private final int luminance;
        private final boolean randomTicks;
        private final boolean giveItemBlock;
        private final boolean hasBlockEntity;

        private Settings(Material material, float hardness, float resistance, float slipperiness, float velocity, float jumpVelocity, int luminance, boolean randomTicks, boolean giveItemBlock, boolean hasBlockEntity) {
            this.material = material;
            this.hardness = hardness;
            this.resistance = resistance;
            this.slipperiness = slipperiness;
            this.velocity = velocity;
            this.jumpVelocity = jumpVelocity;
            this.luminance = luminance;
            this.randomTicks = randomTicks;
            this.giveItemBlock = giveItemBlock;
            this.hasBlockEntity = hasBlockEntity;
        }

        public static Builder builder(Material material) {
            return new Builder(material);
        }

        public static Builder builder(Registry.Entry<Block> block) {
            return builder(block.get());
        }

        public static Builder builder(Block block) {
            return builder(block.getSettings());
        }

        public static Builder builder(Settings settings) {
            return new Builder(settings);
        }

        public boolean doesRandomTick() {
            return randomTicks;
        }

        public boolean giveItemBlock() {
            return giveItemBlock;
        }

        public Material getMaterial() {
            return material;
        }

        public float getHardness() {
            return hardness;
        }

        public float getResistance() {
            return resistance;
        }

        public float getSlipperiness() {
            return slipperiness;
        }

        public float getVelocity() {
            return velocity;
        }

        public float getJumpVelocity() {
            return jumpVelocity;
        }

        public int getLuminance() {
            return luminance;
        }

        public boolean hasBlockEntity() {
            return hasBlockEntity;
        }

        public static class Builder {
            private final Material material;
            private float hardness;
            private float resistance;
            private float slipperiness = 0.6F;
            private float velocity = 1.0F;
            private float jumpVelocity = 1.0F;
            private int luminance;
            private boolean randomTicks;
            private boolean giveItemBlock = true;
            private boolean hasBlockEntity;

            private Builder(Material material) {
                this.material = material;
            }

            private Builder(Settings settings) {
                this(settings.material);
                this.hardness = settings.hardness;
                this.resistance = settings.resistance;
                this.slipperiness = settings.slipperiness;
                this.velocity = settings.velocity;
                this.jumpVelocity = settings.jumpVelocity;
                this.luminance = settings.luminance;
                this.randomTicks = settings.randomTicks;
                this.giveItemBlock = settings.giveItemBlock;
                this.hasBlockEntity = settings.hasBlockEntity;
            }

            public Builder setHardness(float hardness) {
                this.hardness = hardness;
                return this;
            }

            public Builder setStrength(float hardness, float resistance) {
                this.hardness = hardness;
                this.resistance = resistance;
                return this;
            }

            public Builder setStrength(float strength) {
                return setStrength(strength, strength);
            }

            public Builder setResistance(float resistance) {
                this.resistance = resistance;
                return this;
            }

            public Builder setSlipperiness(float slipperiness) {
                this.slipperiness = slipperiness;
                return this;
            }

            public Builder setVelocity(float velocity) {
                this.velocity = velocity;
                return this;
            }

            public Builder setJumpVelocity(float jumpVelocity) {
                this.jumpVelocity = jumpVelocity;
                return this;
            }

            public Builder setLuminance(int luminance) {
                this.luminance = luminance;
                return this;
            }

            public Builder ticksRandomly() {
                this.randomTicks = true;
                return this;
            }

            public Builder removeItemBlock() {
                this.giveItemBlock = false;
                return this;
            }

            public Builder hasBlockEntity() {
                this.hasBlockEntity = true;
                return this;
            }

            public Settings build() {
                return new Settings(material, hardness, resistance, slipperiness, velocity, jumpVelocity, luminance, randomTicks, giveItemBlock, hasBlockEntity);
            }

            private Builder setRandomTicks(boolean randomTicks) {
                this.randomTicks = randomTicks;
                return this;
            }
        }
    }
}