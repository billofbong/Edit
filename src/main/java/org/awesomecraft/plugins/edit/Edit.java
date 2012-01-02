package org.awesomecraft.plugins.edit;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Edit extends JavaPlugin {
    int bId = 0;
    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        getCommand("e").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                if(args.length == 1) {
                    Player sender = (Player) cs;
                    Block btar = sender.getTargetBlock(null, 120);
                    btar.setTypeId(bId);
                }
                return false;
            }
        });
        System.out.println(this + " is now enabled!");
    }
}
