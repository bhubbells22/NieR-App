package com.example.roberthubbell.nier_app.database;

/**
 * Created by Brandon on 4/19/2017.
 */

public class Chip {

    private int id;
    private String name;
    private String description;
    private int enemy_id;
    private String max_effect;
    private String best_setup;

    public Chip(int id,String name,String description, int enemy_id, String max_effect, String best_setup)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.enemy_id=enemy_id;
        this.max_effect=max_effect;
        this.best_setup=best_setup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnemy_id() {
        return enemy_id;
    }

    public void setEnemy_id(int enemy_id) {
        this.enemy_id = enemy_id;
    }

    public String getMax_effect() {
        return max_effect;
    }

    public void setMax_effect(String max_effect) {
        this.max_effect = max_effect;
    }

    public String getBest_setup() {
        return best_setup;
    }

    public void setBest_setup(String best_setup) {
        this.best_setup = best_setup;
    }

}
