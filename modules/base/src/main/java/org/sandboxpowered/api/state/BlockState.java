package org.sandboxpowered.api.state;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Material;
import org.sandboxpowered.api.capability.Capability;
import org.sandboxpowered.api.client.GraphicsMode;
import org.sandboxpowered.api.ecs.Entity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.property.PropertyContainer;
import org.sandboxpowered.api.tags.Tag;
import org.sandboxpowered.api.util.*;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.WorldReader;

public interface BlockState extends PropertyContainer<BlockState> {
    Block getBlock();

    default boolean isAir() {
        return getBlock().isAir(this);
    }

    default Material.PistonInteraction getPistonInteraction() {
        return getBlock().getPistonInteraction(this);
    }

    default boolean canReplace(WorldReader reader, Position pos, Entity player, Hand hand, ItemStack stack, Direction side, Vec3d hitPos) {
        return getBlock().canReplace(reader, pos, this, player, hand, stack, side, hitPos);
    }

    default Block.BlockRenderLayer getRenderLayer(GraphicsMode mode) {
        return getBlock().getRenderLayer(this, mode);
    }

    default BlockState rotate(Rotation rotation) {
        return getBlock().rotate(this, rotation);
    }

    default BlockState mirror(Mirror mirror) {
        return getBlock().mirror(this, mirror);
    }

    default <X> Mono<X> getCapability(WorldReader world, Position position, Capability<X> capability) {
        return getCapability(world, position, capability, null);
    }

    default <X> Mono<X> getCapability(WorldReader world, Position position, Capability<X> capability, @Nullable Direction side) {
        return getBlock().getCapability(world, position, this, capability, side);
    }

    default boolean doesEmitRedstone() {
        return getBlock().doesEmitRedstone(this);
    }

    default boolean hasComparatorValue() {
        return getBlock().hasComparatorValue(this);
    }

    @Range(from = 0, to = 15)
    default int getComparatorValue(WorldReader world, Position pos) {
        return getBlock().getComparatorValue(world, pos, this);
    }

    @Range(from = 0, to = 15)
    default int getWeakPower(WorldReader blockView, Position pos, Direction direction) {
        return getBlock().getWeakPower(blockView, pos, this, direction);
    }

    @Range(from = 0, to = 15)
    default int getStrongPower(WorldReader blockView, Position pos, Direction direction) {
        return getBlock().getStrongPower(blockView, pos, this, direction);
    }

    default FluidState getFluidState() {
        return getBlock().getFluidState(this);
    }

    default boolean is(Block block) {
        return getBlock().isSame(block) || block.isSame(getBlock());
    }

    default boolean isIn(Tag<Block> tag) {
        return tag.contains(getBlock());
    }

    default boolean is(Registry.Entry<Block> entry) {
        return entry.isPresent() && is(entry.get());
    }

    float getDestroySpeed(World world, Position pos);

    @Nullable
    default ToolType getHarvestTool() {
        return getBlock().getHarvestTool(this);
    }

    @Range(from = 0, to = Integer.MAX_VALUE)
    default int getHarvestLevel() {
        return getBlock().getHarvestLevel(this);
    }
}