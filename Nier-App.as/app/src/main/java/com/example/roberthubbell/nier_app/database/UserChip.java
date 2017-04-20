package com.example.roberthubbell.nier_app.database;

/**
 * Created by Brandon on 4/19/2017.
 */

public class UserChip {

    private int id;
    private int level;
    private int size;
    private int count;

    public UserChip(int id, int level, int size, int count){
        this.id=id;
        this.level=level;
        this.size=size;
        this.count=count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
