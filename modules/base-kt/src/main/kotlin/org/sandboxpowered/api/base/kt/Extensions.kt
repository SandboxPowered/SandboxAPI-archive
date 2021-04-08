package org.sandboxpowered.api.base.kt

import org.sandboxpowered.api.ecs.EntityBlueprint
import org.sandboxpowered.api.ecs.component.Component
import org.sandboxpowered.api.inject.FactoryProvider
import org.sandboxpowered.api.registry.Registrar

inline fun <reified T : Registrar.Service> Registrar.useRegistrarService(noinline block: (T) -> Unit) =
    useRegistrarService(T::class.java, block)

inline fun <reified T : Registrar.Service> Registrar.getRegistrarService() = getRegistrarService(T::class.java).let {
    if (it.isPresent) it.get() else null
}

inline fun <reified T : Component> EntityBlueprint.Builder.add(): EntityBlueprint.Builder = add(T::class.java)
inline fun <reified T : Component> EntityBlueprint.Builder.remove(): EntityBlueprint.Builder = remove(T::class.java)

val <T : Content<T>> Registry.Entry<T>.delegate
    get() = RegistryEntryDelegate(this)

class RegistryEntryDelegate<T : Content<T>>(private val entry: Registry.Entry<T>) :
    ReadOnlyProperty<Any?, T?>, () -> T, Registry.Entry<T> by entry {
    override operator fun invoke(): T = get()
    override fun getValue(thisRef: Any?, property: KProperty<*>) = entry.orNull()
}
