package git.olafgoud.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.bananapuncher714.nbteditor.NBTEditor;

public class AddTag implements CommandExecutor{
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
				sender.sendMessage(ChatColor.RED + "Format: <name> <data>");
				return true;
			}
		} catch (Exception e){
			sender.sendMessage(ChatColor.RED + "Format: <name> <data>");
			return true;
		}

		if (args.length < 2){
			return false;
		}
		
		ItemStack item = p.getInventory().getItemInMainHand();
		item = NBTEditor.set(item, args[1], args[0]);
		p.getInventory().setItemInMainHand(item);
		return false;
	}

}
