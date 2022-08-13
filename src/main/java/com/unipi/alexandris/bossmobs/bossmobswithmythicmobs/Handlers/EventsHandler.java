package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.BossMob;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.Utils;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.Location;
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

        MythicBukkit mythicBukkit = (MythicBukkit)(getServer().getPluginManager().getPlugin("MythicMobs"));
        if(mythicBukkit.getAPIHelper().isMythicMob(event.getEntity())) return;

        if(plugin.config.isPlayer_kill_only() && event.getEntity().getKiller() == null) return;

        Location loc = event.getEntity().getLocation();
        for(int i = 0; i <= 5; i++) {
            loc = Utils.randLoc(loc, plugin.config.getRadius_min(), plugin.config.getRadius_max());
            if(Utils.validateSpawnLoc(loc, plugin.config.getEmpty_space_spawn())) break;
            if(i == 5) return;
        }

        List<String> common = plugin.config.get_mobs(event.getEntityType(), 0);
        List<String> rare = plugin.config.get_mobs(event.getEntityType(), 1);
        List<String> legendary = plugin.config.get_mobs(event.getEntityType(), 2);

        if(common != null && !common.isEmpty() && Utils.calcChance(plugin.config.getProb_common())) new BossMob(Utils.rand(common), 0, loc).inst(plugin.config, mythicBukkit);
        else if(rare != null && !rare.isEmpty() && Utils.calcChance(plugin.config.getProb_rare())) new BossMob(Utils.rand(rare), 1, loc).inst(plugin.config, mythicBukkit);
        else if(legendary != null && !legendary.isEmpty() && Utils.calcChance(plugin.config.getProb_legendary())) new BossMob(Utils.rand(legendary), 2, loc).inst(plugin.config, mythicBukkit);

    }
}
