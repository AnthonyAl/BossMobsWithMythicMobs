package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.Utils;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.CommandsHandler;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.ConfigHandler;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.EventsHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossMobsWithMythicMobs extends JavaPlugin {

    public ConfigHandler config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        config = new ConfigHandler(this);
        getCommand("bossmobs").setExecutor(new CommandsHandler(this));
        getServer().getPluginManager().registerEvents(new EventsHandler(this), this);

        config.readConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
