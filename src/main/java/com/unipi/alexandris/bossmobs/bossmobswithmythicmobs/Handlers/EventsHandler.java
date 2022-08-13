package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.BossMob;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.Utils;
import io.lumine.mythic.api.mobs.entities.MythicEntity;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public final class EventsHandler implements Listener {

    private final BossMobsWithMythicMobs plugin;

    public EventsHandler(BossMobsWithMythicMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobPerish(EntityDeathEvent event) {
        if(!plugin.config.contains(event.getEntityType())) return;

        Location loc = event.getEntity().getLocation();
        for(int i = 0; i <= 5; i++) {
            loc = Utils.randLoc(loc, plugin.config.getRadius_min(), plugin.config.getRadius_max());
            if(Utils.validateSpawnLoc(loc, 2)) break;
            if(i == 5) return;
        }

        List<String> common = plugin.config.get_mobs(event.getEntityType(), 0);
        List<String> rare = plugin.config.get_mobs(event.getEntityType(), 1);
        List<String> legendary = plugin.config.get_mobs(event.getEntityType(), 2);

        if(common != null && Utils.calcChance(plugin.config.getProb_common())) new BossMob(Utils.rand(common), loc).inst();
        else if(rare != null && Utils.calcChance(plugin.config.getProb_common())) new BossMob(Utils.rand(rare), loc).inst();
        else if(legendary != null && Utils.calcChance(plugin.config.getProb_common())) new BossMob(Utils.rand(legendary), loc).inst();

    }
}
