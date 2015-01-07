package com.Laxer2117.HealthTransfer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HealthTransfer extends JavaPlugin {
	
	public void onEnable() {
		System.out.println("HealthTransfer has been enabled!");
	}

	public void onDisable() {
		System.out.println("HealthTransfer has been disabled!");
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("health")) {
            if (sender instanceof Player)
                if (args.length == 1)
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player healer = (Player) sender;
                        Player healed = Bukkit.getPlayer(args[0]);
                        double newHealth = healer.getHealth() + healed.getHealth();
                        if (newHealth > healed.getMaxHealth())
                            newHealth = healed.getMaxHealth();
                        healer.setHealth(0.0);
                        healed.setHealth(newHealth);
                        Bukkit.broadcastMessage(ChatColor.DARK_GRAY +  "[" + ChatColor.DARK_RED + "HealthTransfer" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + healed.getName() + "has recieved health from" + healer.getName());
                    } else
                        sender.sendMessage(ChatColor.DARK_RED + args[0] + " is not online");
                else
                    sender.sendMessage(ChatColor.DARK_RED + "Usage: /health [Player]");
            else
                sender.sendMessage(ChatColor.DARK_RED + "You must be a player to do this!");
        }
        return false;
	}
}
