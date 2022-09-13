package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.BossMob;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.Utils;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public final class EventsHandler implements Listener {

    private final BossMobsWithMythicMobs plugin;

    public EventsHandler(BossMobsWithMythicMobs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMobPerish(EntityDeathEvent event) {
        if(plugin.config.isSpawner() && event.getEntity().getEntitySpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER)) return;
        if(!plugin.config.contains(event.getEntityType())) return;

        MythicBukkit mythicBukkit = (MythicBukkit)(getServer().getPluginManager().getPlugin("MythicMobs"));
        if(mythicBukkit.getAPIHelper().isMythicMob(event.getEntity())) return;

        if(plugin.config.isPlayer_kill_only() && event.getEntity().getKiller() == null) return;

        Location loc = event.getEntity().getLocation();
        for(int i = 0; i <= 5; i++) {
            loc = Utils.randLoc(loc, plugin.config.getRadius_min(), plugin.config.getRadius_max());
            if(Utils.validateSpawnLoc(loc, plugin.config.getEmpty_space_spawn())) break;
            if(i == 5) return;
        }

        List<String> mobs = plugin.config.get_mobs(event.getEntityType());
        double noDrop = plugin.config.getNoSpawn(event.getEntityType());
        double total = noDrop;
        HashMap<Double, String[]> weights = new HashMap<>();
        if(mobs != null && !mobs.isEmpty()) for(String rarity : mobs) {
            String[] lords = rarity.split(":")[0].replaceAll(" ", "").split(",");
            total += Double.parseDouble(rarity.split(":")[1]);
            weights.put(total, lords);
        }

        double pull = Utils.randDouble(total);
        if(pull > noDrop)
            for(Double weight : weights.keySet())
                if(pull <= weight) {
                    new BossMob(Utils.rand(Arrays.stream(weights.get(weight)).toList()), loc).inst(mythicBukkit);
                    break;
                }

    }
}
