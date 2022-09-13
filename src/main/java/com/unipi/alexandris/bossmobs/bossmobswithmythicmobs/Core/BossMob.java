package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.ConfigHandler;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.Location;

import static org.bukkit.Bukkit.getLogger;

public final class BossMob {


    private final String type;

    private final Location location;


    public BossMob(String type, Location location) {
        this.type = type;
        this.location = location;
    }

    public void inst(MythicBukkit mythicBukkit) {
        try{
            mythicBukkit.getAPIHelper().spawnMythicMob(type, location, 1);
        }
        catch(Exception e) {
            getLogger().warning("The mythic mob of type " + type + " does not exist.");
        }
    }
}
