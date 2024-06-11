package me.olafgoud.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class More implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("modify")) {
			sender.sendMessage(ChatColor.RED + "You do not have access.");
			return true;
		}
		
		if (p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
			sender.sendMessage(ChatColor.RED + "you must hold an item");
			return true;
		}
		try {
			if (args.length == 1) {
				ItemStack item = p.getInventory().getItemInMainHand();
				item.setAmount(Integer.valueOf(args[0]));
				p.getInventory().setItemInMainHand(item);
				return true;
			}
			else {
				ItemStack item = p.getInventory().getItemInMainHand();
				item.setAmount(64);
				p.getInventory().setItemInMainHand(item);	
			}
		} catch (Exception e) {
			ItemStack item = p.getInventory().getItemInMainHand();
			item.setAmount(64);
			p.getInventory().setItemInMainHand(item);
		}
		return false;
	}

}
