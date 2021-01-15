package org.sandboxpowered.api.inject;

import com.google.inject.PrivateModule;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public class ImplementationModule extends PrivateModule {
    @Override
    @OverridingMethodsMustInvokeSuper
    protected void configure() {
        expose(Implementation.class);
    }
}
