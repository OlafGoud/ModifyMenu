package git.olafgoud.commands;


import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ChangeNameCommand implements CommandExecutor{
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
		ItemMeta meta  = item.getItemMeta();
		String name = args[0];
		if (args.length > 1) {
			for (int i = 1; i < args.length; i++) {
				name += " " + args[i];
			}
		}
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		item.setItemMeta(meta);
		p.getInventory().setItemInMainHand(item);
		
		
		return false;

	}
}