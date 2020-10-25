package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.registry.Registrar;

public interface ResourceRegistrationService extends Registrar.Service {
    ResourceManager<Item> getItemManager();

    ResourceManager<Block> getBlockManager();
}