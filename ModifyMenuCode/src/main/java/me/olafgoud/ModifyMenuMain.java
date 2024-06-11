package me.olafgoud;

import org.bukkit.plugin.java.JavaPlugin;

import me.olafgoud.commands.AddTag;
import me.olafgoud.commands.ChangeNameCommand;
import me.olafgoud.commands.GetLeatherColorCommand;
import me.olafgoud.commands.GlowCommand;
import me.olafgoud.commands.ModifyCommand;
import me.olafgoud.commands.More;
import me.olafgoud.commands.SetLeatherColorCommand;
import me.olafgoud.commands.SetLoreCommand;

public class ModifyMenuMain extends JavaPlugin{
	
	public void onEnable() {
		getCommand("modifygetset").setExecutor(new GetLeatherColorCommand());
		getCommand("modifyatt").setExecutor(new ModifyCommand());
		getCommand("modifyname").setExecutor(new ChangeNameCommand());
		getCommand("modifyglow").setExecutor(new GlowCommand());
		getCommand("modifylore").setExecutor(new SetLoreCommand());
		getCommand("modifyaddtag").setExecutor(new AddTag());
		getCommand("modifysetcolor").setExecutor(new SetLeatherColorCommand());
		getCommand("modifymore").setExecutor(new More());
	}
	
	public void OnDisable() {
		
	}
	
	
}
