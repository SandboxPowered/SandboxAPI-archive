package org.sandboxpowered.api.item.tool;

import org.sandboxpowered.internal.InternalService;

public final class ToolMaterials {
    public static final ToolMaterial WOOD = get("wood");
    public static final ToolMaterial STONE = get("stone");
    public static final ToolMaterial IRON = get("iron");
    public static final ToolMaterial GOLD = get("gold");
    public static final ToolMaterial DIAMOND = get("diamond");
    public static final ToolMaterial NETHERITE = get("netherite");

    private static ToolMaterial get(String material) {
        return InternalService.getInstance().toolMaterial(material);
    }
}
