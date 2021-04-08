package org.sandboxpowered.api.item.tool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class ToolType {
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]");
    private static final Map<String, ToolType> VALUES = new ConcurrentHashMap<>();
    public static final ToolType AXE = get("axe");
    public static final ToolType HOE = get("hoe");
    public static final ToolType PICKAXE = get("pickaxe");
    public static final ToolType SHOVEL = get("shovel");
    public static final ToolType STRIPPER = get("stripper");
    public static final ToolType PAVER = get("paver");
    private final String name;

    public ToolType(String name) {
        this.name = name;
    }

    public static ToolType get(String name) {
        return VALUES.computeIfAbsent(name, (k) -> {
            if (VALID_NAME.matcher(name).find()) {
                throw new IllegalArgumentException(String.format("invalid ToolType name '%s'", name));
            } else {
                return new ToolType(name);
            }
        });
    }

    public String getName() {
        return name;
    }
}