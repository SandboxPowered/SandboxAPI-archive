package org.sandboxpowered.internal;

import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Material;
import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.fluid.FluidStack;
import org.sandboxpowered.api.item.tool.ToolMaterial;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.server.Server;
import org.sandboxpowered.api.shape.Box;
import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.state.property.Property;
import org.sandboxpowered.api.tags.Tag;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Internal;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec2i;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.util.math.Vec3i;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.text.Text;
import org.sandboxpowered.eventhandler.EventHandler;

import java.util.function.Supplier;

/**
 * Everything which used this service should transition to using {@link org.sandboxpowered.api.inject.FactoryProvider}
 */
@Internal
@Deprecated
public interface InternalService {

    @NotNull
    static InternalService getInstance() {
        return SandboxServiceLoader.getOrLoadService(InternalService.class);
    }

    Text createLiteralText(String text);

    Text createTranslatedText(String translation);

    Material getMaterial(String material);

    <T extends BlockEntity> BlockEntity.Type<T> blockEntityTypeFunction(Supplier<T> supplier, Block[] blocks);

    <T extends Content<T>> Registry<T> registryFunction(Class<T> c);

    CompoundTag createCompoundTag();

    <T extends Comparable<T>> Property<T> getProperty(String property);

    Server serverInstance();

    Vec3i createVec3i(int x, int y, int z);

    <T> Component<T> componentFunction(Class<T> c);

    FluidStack fluidStackFunction(Fluid fluid, int amount);

    FluidStack fluidStackFromTagFunction(ReadableCompoundTag tag);

    Identity.Variant createVariantIdentity(Identity identity, String variant);

    Client clientInstance();

    Vec2i createVec2i(int x, int y);

    <X> EventHandler<X> createEventHandler();

    ToolMaterial toolMaterial(String material);

    Tag<Block> getBlockTag(String string);

    Vec3d createVec3d(double x, double y, double z);
}