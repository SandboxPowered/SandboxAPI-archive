package org.sandboxpowered.api.item;

import org.sandboxpowered.api.item.tool.ToolMaterial;

public class ToolItem extends BaseItem {
    private final ToolMaterial material;

    public ToolItem(Settings settings, ToolMaterial material) {
        super(settings);
        this.material = material;
    }

    public ToolMaterial getToolMaterial() {
        return material;
    }
}
