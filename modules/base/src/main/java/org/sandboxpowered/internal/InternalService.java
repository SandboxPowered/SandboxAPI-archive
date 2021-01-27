package org.sandboxpowered.internal;

import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.capability.Capability;
import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.fluid.FluidStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.server.Server;
import org.sandboxpowered.api.state.property.Property;
import org.sandboxpowered.api.tags.Tag;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Internal;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.text.Text;

/**
 * @deprecated Everything which used this service should transition to using {@link org.sandboxpowered.api.inject.FactoryProvider}
 */
@Internal
@Deprecated(forRemoval = true)
public interface InternalService {

    @NotNull
    static InternalService getInstance() {
        return SandboxServiceLoader.getOrLoadService(InternalService.class);
    }

    Text createLiteralText(String text);

    Text createTranslatedText(String translation);

    <T extends Content<T>> Registry<T> registryFunction(Class<T> c);

    <T extends Comparable<T>> Property<T> getProperty(String property);

    Server serverInstance();

    <T> Capability<T> componentFunction(Class<T> c);

    FluidStack fluidStackFunction(Fluid fluid, int amount);

    FluidStack fluidStackFromTagFunction(ReadableCompoundTag tag);

    Identity.Variant createVariantIdentity(Identity identity, String variant);

    Client clientInstance();

    Tag<Block> getBlockTag(String string);
}