package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.CommandsHandler;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.EventsHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class BossMobsWithMythicMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("bossmobs").setExecutor(new CommandsHandler(this));
        getServer().getPluginManager().registerEvents(new EventsHandler(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
