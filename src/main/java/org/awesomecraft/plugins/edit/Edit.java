package org.awesomecraft.plugins.edit;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Edit extends JavaPlugin implements Listener {
    private static Map<String, Integer> bId = new HashMap<String, Integer>();
    private static Map<Player, Boolean> blockEdit = new HashMap<Player, Boolean>();


    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("e").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
               if(cs instanceof Player) {
                   Player sender = (Player) cs;
                if(args.length == 0) {
                    Block btar = sender.getTargetBlock(null, 120);
                    btar.setTypeId(bId.get(sender.toString()));
                    return true;
                }
                else {
                    sender.sendMessage(ChatColor.RED + "Usage: /e");
                }
               }
                else {
                    System.out.println("You must be ingame to use this.");
                }
                return false;
            }
            
        });
        getCommand("em").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                if(cs instanceof Player) {
                        Player sender = (Player) cs;
                    if(args.length == 1) {
                        try {
                        Integer int1 = Integer.parseInt(args[0]);
                        bId.put(sender.toString(), int1);
                        sender.sendMessage(ChatColor.GREEN + "Set edit material to " + int1 + ".");
                        }
                        catch(NumberFormatException e){
                         sender.sendMessage(ChatColor.RED + "You must use the datavalue, not the name!");
                         }
                        return true;
                    }
                    else {
                        sender.sendMessage(ChatColor.RED + "Usage: /em (datavalue)");
                        return false;
                    }
                }
                else {
                    System.out.println("You must be ingame to use this.");
                }
                return false;
            }
        });
        getCommand("be").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                if(args.length == 0) {
                    if(cs instanceof Player) {
                        Player sender = (Player) cs;
                   blockEdit.put(sender, !blockEdit.get(sender));
                   sender.sendMessage(ChatColor.GREEN + "BlockEdit toggled.");
                    }
                }
                
                return false;
            }
        });
        System.out.println(this + " is now enabled!");
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(Edit.blockEdit.containsKey(event.getPlayer())) {
            Player sender = event.getPlayer();
            Block block = event.getClickedBlock();
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            block.setTypeId(Edit.bId.get(sender.toString()));
            }
        }
    }

}
