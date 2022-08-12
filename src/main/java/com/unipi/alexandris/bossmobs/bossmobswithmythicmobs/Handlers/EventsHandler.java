package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public final class EventsHandler implements Listener {

    private final BossMobsWithMythicMobs plugin;

    public EventsHandler(BossMobsWithMythicMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobPerish(EntityDeathEvent event) {
    }
}
