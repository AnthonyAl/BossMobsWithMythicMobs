package com.unipi.alexandris.bossmobs.bossmobswithmythicmobs.Core;

import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;

public class Config {

    private int radius_min;
    private int radius_max;
    private int level_common_min;
    private int level_common_max;
    private int level_rare_min;
    private int level_rare_max;
    private int level_legendary_min;
    private int level_legendary_max;
    private int prob_common;
    private int prob_rare;
    private int prob_legendary;
    private final HashMap<EntityType, List<String>[]> mob_map = new HashMap<>();

    public void put_to_map(EntityType type, List<String>[] mobs) {
        mob_map.put(type, mobs);
    }

    public boolean contains(EntityType key) {
        return mob_map.containsKey(key);
    }

    public List<String> get_mobs(EntityType key, int rarity) {
        if(mob_map.containsKey(key)) return mob_map.get(key)[rarity];
        else return null;
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

    public int getLevel_common_min() {
        return level_common_min;
    }

    public void setLevel_common_min(int level_common_min) {
        this.level_common_min = level_common_min;
    }

    public int getLevel_common_max() {
        return level_common_max;
    }

    public void setLevel_common_max(int level_common_max) {
        this.level_common_max = level_common_max;
    }

    public int getLevel_rare_min() {
        return level_rare_min;
    }

    public void setLevel_rare_min(int level_rare_min) {
        this.level_rare_min = level_rare_min;
    }

    public int getLevel_rare_max() {
        return level_rare_max;
    }

    public void setLevel_rare_max(int level_rare_max) {
        this.level_rare_max = level_rare_max;
    }

    public int getLevel_legendary_min() {
        return level_legendary_min;
    }

    public void setLevel_legendary_min(int level_legendary_min) {
        this.level_legendary_min = level_legendary_min;
    }

    public int getLevel_legendary_max() {
        return level_legendary_max;
    }

    public void setLevel_legendary_max(int level_legendary_max) {
        this.level_legendary_max = level_legendary_max;
    }

    public int getProb_common() {
        return prob_common;
    }

    public void setProb_common(int prob_common) {
        this.prob_common = prob_common;
    }

    public int getProb_rare() {
        return prob_rare;
    }

    public void setProb_rare(int prob_rare) {
        this.prob_rare = prob_rare;
    }

    public int getProb_legendary() {
        return prob_legendary;
    }

    public void setProb_legendary(int prob_legendary) {
        this.prob_legendary = prob_legendary;
    }
}
