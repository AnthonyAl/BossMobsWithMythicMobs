package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Handlers;

import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.BossMobsWithMythicMobs;
import com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

import java.util.List;

@SuppressWarnings("unused")
public final class ConfigHandler {

    private final Config config = new Config();

    private final BossMobsWithMythicMobs plugin;

    public ConfigHandler(BossMobsWithMythicMobs plugin) {
        this.plugin = plugin;
        FileConfiguration fileConfiguration = plugin.getConfig();

        config.setPlayer_kill_only(fileConfiguration.getBoolean("player_kill_only"));
        config.setSpawner(fileConfiguration.getBoolean("spawner"));
        config.setEmpty_space_spawn(fileConfiguration.getInt("empty_space_spawn"));
        config.setRadius_min(fileConfiguration.getInt("radius.min"));
        config.setRadius_max(fileConfiguration.getInt("radius.max"));

        for(EntityType type : EntityType.values()) {
            String path = "mobs.";
            if(!fileConfiguration.contains(path += type.toString().toLowerCase())) continue;
            List<String> mobs = (List<String>) fileConfiguration.getList(path+"lords");
            config.put_to_map(type, mobs);
        }
    }

    public double getNoSpawn(EntityType type) {
        FileConfiguration fileConfiguration = plugin.getConfig();
        return fileConfiguration.getDouble("mobs." + type.toString().toLowerCase() + "no_spawn");
    }

    public boolean contains(EntityType key) {
        return config.contains(key);
    }

    public List<String> get_mobs(EntityType key) {
        return config.get_mobs(key);
    }

    public boolean isSpawner() {
        return config.isSpawner();
    }

    public boolean isPlayer_kill_only() {
        return config.isPlayer_kill_only();
    }

    public int getEmpty_space_spawn() {
        return config.getEmpty_space_spawn();
    }

    public int getRadius_min() {
        return config.getRadius_min();
    }

    public int getRadius_max() {
        return config.getRadius_max();
    }
}
