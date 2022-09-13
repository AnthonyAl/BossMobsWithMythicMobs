package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core;

import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;

public class Config {

    private boolean player_kill_only;

    private boolean natural_only;

    private int empty_space_spawn;
    private int radius_min;
    private int radius_max;
    private final HashMap<EntityType, List<String>> mob_map = new HashMap<>();

    public void put_to_map(EntityType type, List<String> mobs) {
        mob_map.put(type, mobs);
    }

    public boolean contains(EntityType key) {
        return mob_map.containsKey(key);
    }

    public List<String> get_mobs(EntityType key) {
        return mob_map.getOrDefault(key, null);
    }

    public boolean isPlayer_kill_only() {
        return player_kill_only;
    }

    public void setPlayer_kill_only(boolean player_kill_only) {
        this.player_kill_only = player_kill_only;
    }

    public boolean isNatural_only() {
        return natural_only;
    }

    public void setNatural_only(boolean natural_only) {
        this.natural_only = natural_only;
    }

    public int getEmpty_space_spawn() {
        return empty_space_spawn;
    }

    public void setEmpty_space_spawn(int empty_space_spawn) {
        this.empty_space_spawn = empty_space_spawn;
    }

    public int getRadius_min() {
        return radius_min;
    }

    public void setRadius_min(int radius_min) {
        this.radius_min = radius_min;
    }

    public int getRadius_max() {
        return radius_max;
    }

    public void setRadius_max(int radius_max) {
        this.radius_max = radius_max;
    }
}
