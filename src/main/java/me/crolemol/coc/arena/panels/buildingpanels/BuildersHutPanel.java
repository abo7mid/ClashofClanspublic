package me.crolemol.coc.arena.panels.buildingpanels;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.crolemol.coc.Coc;
import me.crolemol.coc.arena.building.BuildersHut;
import me.crolemol.coc.arena.building.interfaces.BuildingPanel;
import me.crolemol.coc.arena.building.interfaces.BuildingSpecs;

public class BuildersHutPanel implements BuildingPanel{

	Coc plugin = Coc.getPlugin();
	BuildersHut building;
	
	public BuildersHutPanel(BuildersHut building){
		this.building = building;

	}
	@Override
	public Inventory getInventory(){
		BuildingSpecs[] spec = building.getBuildingSpecs();
		Inventory inv2 = Bukkit.createInventory(null, 9, "Builder's hut");
		
		ItemStack Info = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta InfoMeta = Info.getItemMeta();
		InfoMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Info");
		List<String> list = new ArrayList<String>();
		list.add("Nothing gets done around here without Builders!");
		list.add("You can hire more Builders to start multiple construction projects,");
		list.add("or speed up their work by using green gems.");
		if(building.getLevel() != 0){
		list.add("Level: "+building.getLevel());
		list.add("Health: "+ spec[building.getLevel()-1].getHealth());
		}
		InfoMeta.setLore(list);
		Info.setItemMeta(InfoMeta);
		
		inv2.setItem(0, Info);
		return inv2;
	}

}
