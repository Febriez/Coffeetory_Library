package com.coffeetory.lib.data;

import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class DataPack {

    private final File file;

    private final String data;

    public DataPack(String data, File file) {
        this.data = data;
        this.file = file;
    }

    public void save() throws IOException {
        YamlConfiguration config = new YamlConfiguration();
        config.set("data", data);
        config.save(file);
    }

    public @Nullable String get() {
        if (!file.exists()) return null;
        return YamlConfiguration.loadConfiguration(file).getString("data");
    }

}
