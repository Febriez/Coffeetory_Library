package com.coffeetory.lib;

import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class LibraryMain extends JavaPlugin {

    private static LibraryMain instance;

    public void onEnable() {
        instance = this;
        getLogger().fine("로드 완료.");
    }

    public static LibraryMain getInstance() {
        return instance;
    }
}
