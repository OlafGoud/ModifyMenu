package git.olafgoud.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import net.md_5.bungee.api.ChatColor;

public class CreateItemStack {
	public ItemStack item;
	
	public CreateItemStack(Material mat) {
		this.item = new ItemStack(mat);
	}

	public void setName(String name) {
		ItemMeta meta = this.item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		this.item.setItemMeta(meta);
	}
	
	public void setLore(String ... lore) {
		ItemMeta meta = this.item.getItemMeta();
		List<String> lores = new ArrayList<>();
		for (String s : lore) {
			lores.add(ChatColor.translateAlternateColorCodes('&', s));
		}
		meta.setLore(lores);
		
		this.item.setItemMeta(meta);
	}
	
	
	public void setKey(String key, String value) {
		this.item = NBTEditor.set(this.item, value, key);
	}
	
	public void setUnbreakable(boolean unbreakable) {
		this.item = NBTEditor.set(this.item, unbreakable, "Unbreakable");
	}
	
	
	public ItemStack getItem() { 
		return this.item;
	}
	
	
	
}
