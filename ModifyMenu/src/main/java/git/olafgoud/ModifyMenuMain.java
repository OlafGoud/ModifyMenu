package git.olafgoud;

import org.bukkit.plugin.java.JavaPlugin;

import git.olafgoud.commands.AddTag;
import git.olafgoud.commands.CanBreak;
import git.olafgoud.commands.ChangeNameCommand;
import git.olafgoud.commands.GetLeatherColorCommand;
import git.olafgoud.commands.GlowCommand;
import git.olafgoud.commands.HideFlags;
import git.olafgoud.commands.ModifyCommand;
import git.olafgoud.commands.More;
import git.olafgoud.commands.SetLeatherColorCommand;
import git.olafgoud.commands.SetLoreCommand;

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
		getCommand("modifycanbreak").setExecutor(new CanBreak());
		getCommand("modifyhideflags").setExecutor(new HideFlags());
	}
	
	public void OnDisable() {
		
	}
	
	
}
