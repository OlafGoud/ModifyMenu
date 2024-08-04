package git.olafgoud.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_12_R1.NBTBase;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class CanBreak implements CommandExecutor{
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
			if(args.length < 1) {
				sender.sendMessage(ChatColor.RED + "Please give ints for the id's");
				return true;
			}
		} catch (Exception e){
			sender.sendMessage(ChatColor.RED + "Please give ints for the id's");
			return true;
		}
		
		ItemStack item = p.getInventory().getItemInMainHand();
		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		
		

        NBTTagList list = new NBTTagList();
        for(int i = 0; i < args.length; i++) {
            list.add((NBTBase)new NBTTagString(args[i]));

        }

     
        compound.set("CanDestroy", list);  
       	nmsStack.setTag(compound); 
        item = CraftItemStack.asBukkitCopy(nmsStack);
        p.getInventory().setItemInMainHand(item);
		return false;

	}

}
