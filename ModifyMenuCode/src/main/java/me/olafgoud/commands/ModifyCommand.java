package me.olafgoud.commands;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagDouble;
import net.minecraft.server.v1_12_R1.NBTTagInt;
import net.minecraft.server.v1_12_R1.NBTTagList;
import net.minecraft.server.v1_12_R1.NBTTagString;

public class ModifyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can use this command");
			return true;
		}
		Player player = (Player) sender;
		// <modifier> <slot> <amount>
		
		
		if (!player.hasPermission("canModify")) {
			return true;
		}
		try {
			if (args.length < 3) {
				player.sendMessage(ChatColor.RED  + " " + ChatColor.BOLD + "format: <armor, attackspeed, damage, speed, health> <mainhand, offhand, feet, legs, chest, head> <number>");
				return true;
			}
		} catch (Exception e) {
			player.sendMessage(ChatColor.RED  + " " + ChatColor.BOLD + "format: <armor, attackspeed, damage, speed, health> <mainhand, offhand, feet, legs, chest, head> <number>");
		}
		if (player.getInventory().getItemInMainHand() == null) {
			player.sendMessage(ChatColor.RED + "you must hold something");
			return true;
		}
		
		
		
		
		
		switch (args[1]) {
 		case "mainhand": break;
 		case "offhand": break;
 		case "feet": break;
 		case "legs": break;
 		case "chest": break;
 		case "head": break;
 		default: player.sendMessage("It must be one of those: mainhand, offhand, feet, legs, chest, head"); return true;
		}
		
		net.minecraft.server.v1_12_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(player.getInventory().getItemInMainHand());
		NBTTagCompound compound = (nmsStack.hasTag()) ? nmsStack.getTag() : new NBTTagCompound();
		NBTTagList modifiers = new NBTTagList();
		Random rand = new Random();
		switch (args[0]) {	
		case "health":
			NBTTagCompound health = compound.getCompound("generic.maxHealth");
			Integer int0 = rand.nextInt(1000000);
			modifiers.add(health);
	        health.set("AttributeName", new NBTTagString("generic.maxHealth"));
	        health.set("Name", new NBTTagString("generic.maxHealth"));
	        health.set("Amount", new NBTTagDouble(Double.parseDouble(args[2])));
	        health.set("Operation", new NBTTagInt(0));
	        health.set("UUIDLeast", new NBTTagInt(int0));
	        health.set("UUIDMost", new NBTTagInt(int0));
	        health.set("Slot", new NBTTagString(args[1]));
	        modifiers.add(health);
	        break;
		case "speed":
			NBTTagCompound speed = compound.getCompound("generic.movementSpeed");
			modifiers.add(speed);
			Integer int1 = rand.nextInt(1000000);
	        speed.set("AttributeName", new NBTTagString("generic.movementSpeed"));
	        speed.set("Name", new NBTTagString("generic.movementSpeed"));
	        speed.set("Amount", new NBTTagDouble(Double.parseDouble(args[2])));
	        speed.set("Operation", new NBTTagInt(0));
	        speed.set("UUIDLeast", new NBTTagInt(int1));
	        speed.set("UUIDMost", new NBTTagInt(int1));
	        speed.set("Slot", new NBTTagString(args[1]));
	        modifiers.add(speed);
	        break;
		case "damage":
			Integer int2 = rand.nextInt(1000000);
	        NBTTagCompound damage = new NBTTagCompound();
	        damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
	        damage.set("Name", new NBTTagString("generic.attackDamage"));
	        damage.set("Amount", new NBTTagDouble(Double.parseDouble(args[2])));
	        damage.set("Operation", new NBTTagInt(0));
	        damage.set("UUIDLeast", new NBTTagInt(int2));
	        damage.set("UUIDMost", new NBTTagInt(int2));
	        damage.set("Slot", new NBTTagString(args[1]));
	        modifiers.add(damage);
	        break;
		case "attackspeed":
			Integer int3 = rand.nextInt(1000000);
	        NBTTagCompound attackspeed = new NBTTagCompound();
	        attackspeed.set("AttributeName", new NBTTagString("generic.attackSpeed"));
	        attackspeed.set("Name", new NBTTagString("generic.attackSpeed"));
	        attackspeed.set("Amount", new NBTTagDouble(Double.parseDouble(args[2])));
	        attackspeed.set("Operation", new NBTTagInt(0));
	        attackspeed.set("UUIDLeast", new NBTTagInt(int3));
	        attackspeed.set("UUIDMost", new NBTTagInt(int3));
	        attackspeed.set("Slot", new NBTTagString(args[1]));
	        modifiers.add(attackspeed);
	        break;
		case "armor":
			Integer int4 = rand.nextInt(1000000);
	        NBTTagCompound armor = new NBTTagCompound();
	        armor.set("AttributeName", new NBTTagString("generic.armor"));
	        armor.set("Name", new NBTTagString("generic.armor"));
	        armor.set("Amount", new NBTTagDouble(Double.parseDouble(args[2])));
	        armor.set("Operation", new NBTTagInt(0));
	        armor.set("UUIDLeast", new NBTTagInt(int4));
	        armor.set("UUIDMost", new NBTTagInt(int4));
	        armor.set("Slot", new NBTTagString(args[1]));
	        modifiers.add(armor);
			break;
		default:
			player.sendMessage(ChatColor.RED + "format: <armor, attackspeed, damage, speed, health> <mainhand, offhand, feet, legs, chest, head> <number>");
			return true;
		}
		compound.set("AttributeModifiers", modifiers);
		nmsStack.setTag(compound);
        ItemStack item = CraftItemStack.asBukkitCopy(nmsStack);
        player.getInventory().setItemInMainHand(item);
		
		return true;
	}
	
}
