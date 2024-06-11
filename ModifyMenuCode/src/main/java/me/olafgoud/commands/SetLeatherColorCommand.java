package me.olafgoud.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagInt;

public class SetLeatherColorCommand implements CommandExecutor {
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
		try {
			if(args == null) {
				sender.sendMessage(ChatColor.RED + "Please give a colorcode as 255 255 255");
				return true;
			}
		} catch (Exception e){
			sender.sendMessage(ChatColor.RED + "Please give a colorcode as 255 255 255");
			return true;
		}
		
		
		if (args.length == 3) {
			int red = Integer.valueOf(args[0]);
			int color = (int) (red << 16);
			color += (int) (Integer.valueOf(args[1]) << 8);
			color += Integer.valueOf(args[2]);
			ItemStack item = p.getInventory().getItemInMainHand();
			item = colorCode(item, color);
			p.getInventory().setItemInMainHand(item);
			return true;

		}
		
		
		return true;
	}
	
	
	private ItemStack colorCode(ItemStack item, int color) {
		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagCompound display = new NBTTagCompound();
		
		display.set("color", new NBTTagInt(color));
		compound.set("display", display);
		nmsStack.setTag(compound);
		item = CraftItemStack.asBukkitCopy(nmsStack);
		return item;
	}

}
