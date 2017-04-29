package com.example.roberthubbell.nier_app;

import com.example.roberthubbell.nier_app.chip.Fusion;
import com.example.roberthubbell.nier_app.database.DatabaseAccess;

import java.util.ArrayList;

/**
 * Created by Brandon on 4/12/2017.
 */

public class MyProperties {
    private static MyProperties mInstance= null;

    public int chip_id = 1;
    public int chip_category = 1;
    public int chip_level = 0;
    public String[] chips = {"Select Chip", "Charge Attack", "Counter", "Critical Up", "Down-Attack Up", "Last Stand", "Ranged Attack Up", "Shock Wave", "Weapon Attack Up",
                            "Anti Chain Damage", "Auto-Heal", "Damage Absorb", "Deadly Heal", "Max HP Up", "Melee Defense Up", "Offensive Heal", "Ranged Defense",
                            "Reset", "Resilience", "Auto-Use Item", "Drop Rate Up", "EXP Gain Up", "Evade Range Up", "Fast Cooldown", "Moving Speed Up", "Overclock",
                            "Taunt Up", "Vengeance", "Combust", "Heal Drops Up", "Hijack Boost", "Stun"};
    public ArrayList<Fusion> fusionLog = new ArrayList<Fusion>();

    public static synchronized MyProperties getInstance(){
        if(null == mInstance){
            mInstance = new MyProperties();
        }
        return mInstance;
    }


}