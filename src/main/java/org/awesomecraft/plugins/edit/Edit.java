package org.awesomecraft.plugins.edit;

import org.bukkit.plugin.java.JavaPlugin;

public class Edit extends JavaPlugin {
    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        System.out.println(this + " is now enabled!");
    }
}
