package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers.ConfigHandler;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.Location;

import static org.bukkit.Bukkit.getLogger;

public final class BossMob {


    private final String type;

    private final Location location;

    private final int rarity;

    public BossMob(String type, int rarity, Location location) {
        this.type = type;
        this.location = location;
        this.rarity = rarity;
    }

    public void inst(ConfigHandler config, MythicBukkit mythicBukkit) {
        try{
            int level = switch (rarity) {
                case 0 -> Utils.randLevel(config.getLevel_common_min(), config.getLevel_common_max());
                case 1 -> Utils.randLevel(config.getLevel_rare_min(), config.getLevel_rare_max());
                case 2 -> Utils.randLevel(config.getLevel_legendary_min(), config.getLevel_legendary_max());
                default -> 1;
            };

            mythicBukkit.getAPIHelper().spawnMythicMob(type, location, level);
        }
        catch(Exception e) {
            getLogger().warning("The mythic mob of type " + type + " does not exist.");
        }
    }
}
