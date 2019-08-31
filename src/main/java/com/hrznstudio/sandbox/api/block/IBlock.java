package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.block.state.StateFactory;
import com.hrznstudio.sandbox.api.entity.IEntity;
import com.hrznstudio.sandbox.api.entity.player.Hand;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.item.ItemProvider;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.InteractionResult;
import com.hrznstudio.sandbox.api.util.Mirror;
import com.hrznstudio.sandbox.api.util.Rotation;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3f;
import com.hrznstudio.sandbox.api.world.World;
import com.hrznstudio.sandbox.api.world.WorldReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface IBlock extends ItemProvider {

    /**
     * The {@link Properties} assigned to the Block
     */
    Properties getProperties();

    /**
     * Grabs the Block as an {@link IItem}
     */
    @Nullable
    @Override
    IItem asItem();

    /**
     * Gets called when the block is interacted with by a {@link Player}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    @Nonnull
    default InteractionResult onBlockUsed(World world, Position pos, BlockState state, Player player, Hand hand, Direction side, Vec3f hit) {
        return InteractionResult.IGNORE;
    }

    /**
     * Gets called when the block is clicked by a {@link Player}
     *
     * @return The {@link InteractionResult} of the interaction
     */
    @Nonnull
    default InteractionResult onBlockClicked(World world, Position pos, BlockState state, Player player) {
        return InteractionResult.IGNORE;
    }

    BlockState getBaseState();

    StateFactory<IBlock, BlockState> getStateFactory();

    /**
     * Gets called when the block is placed
     */
    default void onBlockPlaced(World world, Position position, BlockState state, IEntity entity, ItemStack itemStack) {
    }

    /**
     * Gets called when the block is broken
     */
    default void onBlockDestroyed(World world, Position position, BlockState state) {
    }

    /**
     * Updates the @{@link BlockState} when a neighbor block updates
     *
     * @return The @{@link BlockState} to set in the world
     */
    default BlockState updateOnNeighborChanged(BlockState state, Direction direction, BlockState otherState, World world, Position position, Position otherPosition) {
        return state;
    }

    /**
     * Whether the block has a @{@link IBlockEntity} attached to it
     */
    default boolean hasBlockEntity() {
        return false;
    }

    /**
     * Creates a new @{@link IBlockEntity} for this block
     *
     * Make sure to return true in @{@link this#hasBlockEntity()} to use this
     */
    default IBlockEntity createBlockEntity(WorldReader reader) {
        return null;
    }

    default BlockState rotate(BlockState state, Rotation rotation) {
        return state;
    }

    default BlockState mirror(BlockState state, Mirror mirror) {
        return state;
    }

    default boolean canReplace(BlockState state) {
        return getMaterial().isReplaceable();
    }

    default boolean isAir(BlockState state) {
        return false;
    }

    default void onEntityWalk(World world, Position position, IEntity entity) {

    }

    default boolean canEntitySpawnWithin() {
        return !getMaterial().isSolid() && !getMaterial().isLiquid();
    }
    
    default Material.PistonInteraction getPistonInteraction(BlockState state) {
        return getMaterial().getPistonInteraction();
    }
    
    default Material getMaterial() {
        return getProperties().getMaterial();
    }

    default ItemStack getPickStack(WorldReader reader, Position position, BlockState state) {
        return ItemStack.of(this);
    }

    default boolean isNaturalDirt() {
        return false;
    }

    default boolean isNaturalStone() {
        return false;
    }

    class Properties {
        private final Material material;

        public Properties(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }
    }
}