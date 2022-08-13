package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;
import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public abstract class Utils {

    public static String rand(List<String> list) {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    public static boolean calcChance(int rarity) {
        Random r = new Random();
        return r.nextInt() < rarity;
    }

    public static Location randLoc(Location loc, int min, int max) {
        Random r = new Random();
        World world = loc.getWorld();
        double x = r.nextDouble(loc.getX() + min, loc.getX() + max) + 0.5;
        double y = r.nextDouble (loc.getY() + max) + 0.5;
        double z = r.nextDouble(loc.getZ() + min, loc.getZ() + max) + 0.5;
        return new Location(world, x, y, z);
    }

    public static boolean validateSpawnLoc(Location loc, int radius) {

        for(int x = (int)(loc.getX() - radius - 1); x < loc.getX() + radius; x++)
            for(int y = (int)(loc.getY() - radius - 1); x < loc.getY() + radius; y++)
                for(int z = (int)(loc.getZ() - radius - 1); x < loc.getZ() + radius; z++)
                    if(!loc.getWorld().getBlockAt(new Location(loc.getWorld(), x, y, z)).isEmpty()) return false;
        return true;
    }

}
