package com.coffeetory.lib;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class LibraryMain extends JavaPlugin {

    private static LibraryMain instance;

    public void onEnable() {
        instance = this;
        getLogger().fine("로드 완료.");
    }

    public static void registerCommand(PluginCommand cmd, Object clazz) {
        if (cmd == null) return;
        if (clazz instanceof CommandExecutor) cmd.setExecutor((CommandExecutor) clazz);
        if (clazz instanceof TabCompleter) cmd.setTabCompleter((TabCompleter) clazz);
    }

    public static LibraryMain getInstance() {
        return instance;
    }
}
