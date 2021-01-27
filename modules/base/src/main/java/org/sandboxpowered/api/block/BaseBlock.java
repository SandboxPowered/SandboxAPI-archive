package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.capability.Capabilities;
import org.sandboxpowered.api.capability.Capability;
import org.sandboxpowered.api.capability.fluid.FluidLoggingContainer;
import org.sandboxpowered.api.ecs.CapabilityManager;
import org.sandboxpowered.api.item.BaseBlockItem;
import org.sandboxpowered.api.item.BlockItem;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.Properties;
import org.sandboxpowered.api.state.StateFactory;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.annotation.Internal;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.WorldReader;

import java.util.Optional;

public class BaseBlock implements Block {
    private final Settings settings;
    private Registry.Entry<Item> itemCache;
    private StateFactory<Block, BlockState> stateFactory;
    private BlockState baseState;
    private Identity identity;

    public BaseBlock(Settings settings) {
        this.settings = settings;
    }

    @Override
    public final Settings getSettings() {
        return settings;
    }

    @Override
    public final StateFactory<Block, BlockState> getStateFactory() {
        return stateFactory;
    }

    @Internal
    public final void setStateFactory(StateFactory<Block, BlockState> stateFactory) {
        this.stateFactory = stateFactory;
        this.baseState = createBaseState(stateFactory.getBaseState());
    }

    @Override
    public Identity getIdentity() {
        return identity;
    }

    public BlockItem createBlockItem() {
        if (getSettings().giveItemBlock())
            return new BaseBlockItem(this, new Item.Settings());
        return null;
    }

    @Override
    public Block setIdentity(Identity identity) {
        if (this.identity != null)
            throw new UnsupportedOperationException("Cannot set identity on content with existing identity");
        this.identity = identity;
        return this;
    }

    protected BlockState createBaseState(BlockState baseState) {
        return baseState;
    }

    @Override
    public Optional<Item> asItem() {
        if (itemCache == null) {
            itemCache = Item.REGISTRY.get(getIdentity());
        }
        return itemCache.getAsOptional();
    }

    @Override
    public final <X> Mono<X> getCapability(WorldReader world, Position position, BlockState state, Capability<X> capability) {
        return getCapability(world, position, state, capability, null);
    }

    @Override
    public <X> Mono<X> getCapability(WorldReader world, Position position, BlockState state, Capability<X> capability, @Nullable Direction side) {
        if (this instanceof FluidLoggable && capability == Capabilities.FLUID_CAPABILITY) {
            return Mono.of(new FluidLoggingContainer((FluidLoggable) this, world, position, state, side)).cast();
        } else if (getSettings().hasBlockEntity()) {
            int be = world.getBlockEntity(position);
            if(be != -1) {
                return world.getCapabilityManager().getBlockEntityCapability(be, capability, side);
            }
        }
        return Mono.empty();
    }

    public void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
        if (this instanceof FluidLoggable && ((FluidLoggable) this).needsWaterloggedProperty()) {
            builder.add(Properties.WATERLOGGED);
        }
    }

    @Override
    public final BlockState getBaseState() {
        return baseState;
    }
}