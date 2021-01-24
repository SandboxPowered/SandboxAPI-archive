package org.sandboxpowered.api.base.kt

import org.sandboxpowered.api.ecs.EntityBlueprint
import org.sandboxpowered.api.ecs.component.EntityComponent
import org.sandboxpowered.api.registry.Registrar

inline fun <reified T: Registrar.Service> Registrar.useRegistrarService(noinline block: (T) -> Unit) = useRegistrarService(T::class.java, block)

inline fun <reified T: Registrar.Service> Registrar.getRegistrarService(): T? {
    return getRegistrarService(T::class.java).let {
        if(it.isPresent) it.get() else null
    }
}
inline fun <reified T: EntityComponent> EntityBlueprint.Builder.add(): EntityBlueprint.Builder = add(T::class.java)
inline fun <reified T: EntityComponent> EntityBlueprint.Builder.remove(): EntityBlueprint.Builder = remove(T::class.java)