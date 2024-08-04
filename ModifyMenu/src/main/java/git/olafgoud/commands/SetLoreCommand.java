package git.olafgoud.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetLoreCommand implements CommandExecutor{
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
			if(args == null) {
				sender.sendMessage(ChatColor.RED + "Please give a colorcode as 255 255 255");
				return true;
			}
		} catch (Exception e){
			sender.sendMessage(ChatColor.RED + "Please give a colorcode as 255 255 255");
			return true;
		}
		
		ItemStack item = p.getInventory().getItemInMainHand();
		item = setLore(item, args);
		p.getInventory().setItemInMainHand(item);
		
		return false;
		
	}
	
	
	
	public ItemStack setLore(ItemStack item, String ... lore) {
		ItemMeta meta = item.getItemMeta();
		List<String> lores = new ArrayList<>();
		for (String s : lore) {
			lores.add(ChatColor.translateAlternateColorCodes('&', s));
		}
		meta.setLore(lores);
		
		item.setItemMeta(meta);
		return item;
	}
}
