package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core;

import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public final class BossMob {

    private ActiveMob mob;

    private final String type;

    private final Location location;

    public BossMob(String type, Location location) {
        this.type = type;
        this.location = location;
    }

    public void inst() {
        try{
            MythicBukkit mythicBukkit = (MythicBukkit)(getServer().getPluginManager().getPlugin("MythicMobs"));

            assert mythicBukkit != null;
            mob = mythicBukkit.getAPIHelper().getMythicMobInstance(mythicBukkit.getAPIHelper().spawnMythicMob(type, location, 5));
        }
        catch(Exception e) {
            getLogger().warning("The mythic mob of type " + type + " does not exist.");
        }
    }

    public boolean isMob(ActiveMob mob) {
        return mob.equals(this.mob);
    }
}
