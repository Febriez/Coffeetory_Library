package com.coffeetory.lib;

import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class LibraryMain extends JavaPlugin {

    private static LibraryMain instance;

    public void onEnable() {
        instance = this;
        getLogger().fine("커피토리 라이브러리 정상 로드.");
    }

    public static LibraryMain getInstance() {
        return instance;
    }
}
