package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Utils {

    public static String rand(List<String> list) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        return list.get(r.nextInt(list.size()));
    }

    public static double randDouble(double max) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        return r.nextDouble(max);
    }

    public static boolean calcChance(double rarity) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        return r.nextDouble(100) < rarity;
    }

    public static Location randLoc(Location loc, int min, int max) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        World world = loc.getWorld();
        double x = getRandomWithExclusion(r, (int)(loc.getX() - max), (int)(loc.getX() + max), (int)(loc.getX() - min), (int)(loc.getX() + min)) + 0.5;
        double y = r.nextInt ((int)loc.getY(), (int)loc.getY() + 2) + 0.5;
        double z = getRandomWithExclusion(r, (int)(loc.getZ() - max), (int)(loc.getZ() + max), (int)(loc.getZ() - min), (int)(loc.getZ() + min)) + 0.5;
        return new Location(world, x, y, z);
    }

    private static int getRandomWithExclusion(Random rnd, int start, int end, int exclude_start, int exclude_end) {
        int random = start + rnd.nextInt(end - start + 1 - (exclude_end - exclude_start));
        for (int ex = exclude_start; ex <= exclude_end; ex++) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public static boolean validateSpawnLoc(Location loc, int radius) {

        for(int x = (int)(loc.getX() - radius - 1); x < loc.getX() + radius; x++)
            for(int y = (int)(loc.getY()- 1); y < loc.getY() + radius; y++)
                for(int z = (int)(loc.getZ() - radius - 1); z < loc.getZ() + radius; z++)
                    if(!loc.getWorld().getBlockAt(new Location(loc.getWorld(), x, y, z)).isEmpty()) return false;
        return true;
    }

}
