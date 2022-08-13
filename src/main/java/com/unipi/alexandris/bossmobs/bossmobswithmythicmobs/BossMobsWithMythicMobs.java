package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.CommandsHandler;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.ConfigHandler;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.EventsHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BossMobsWithMythicMobs extends JavaPlugin {

    public ConfigHandler config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        config = new ConfigHandler(this);
        Objects.requireNonNull(getCommand("bossmobs")).setExecutor(new CommandsHandler(this));
        getServer().getPluginManager().registerEvents(new EventsHandler(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
