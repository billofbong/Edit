package org.awesomecraft.plugins.edit;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Edit extends JavaPlugin {
    Map<String, Integer> bId = new HashMap<String, Integer>();
    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        getCommand("e").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
               if(cs instanceof Player) { 
                if(args.length == 0) {
                    Player sender = (Player) cs;
                    Block btar = sender.getTargetBlock(null, 120);
                    btar.setTypeId(bId.get(sender.toString()));
                    return true;
                }
               }
                return false;
            }
            
        });
        getCommand("em").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                if(cs instanceof Player) {
                    if(args.length == 1) {
                        Integer int1 = Integer.parseInt(args[0]);
                        Player sender = (Player) cs;
                        bId.put(sender.toString(), int1);
                        sender.sendMessage(ChatColor.GREEN + "Set edit material to " + int1 + ".");
                        return true;
                    }
                }
                return false;
            }
        });
        System.out.println(this + " is now enabled!");
    }
}
