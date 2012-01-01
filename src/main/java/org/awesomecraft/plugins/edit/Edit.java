package org.awesomecraft.plugins.edit;

import org.bukkit.plugin.java.JavaPlugin;

public class Edit extends JavaPlugin {
    public void onDisable() {
        // TODO: Place any custom disable code here.
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        // TODO: Place any custom enable code here, such as registering events
        
        System.out.println(this + " is now enabled!");
    }
}
