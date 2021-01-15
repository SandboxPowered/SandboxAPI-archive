package org.sandboxpowered.api.base.kt

import org.sandboxpowered.api.registry.Registrar

inline fun <reified T: Registrar.Service> Registrar.useRegistrarService(noinline block: (T) -> Unit) = useRegistrarService(T::class.java, block)