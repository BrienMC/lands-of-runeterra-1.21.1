package net.brien.landsofruneterra;

import net.brien.landsofruneterra.block.ModBlocks;
import net.brien.landsofruneterra.item.ModItemGroups;
import net.brien.landsofruneterra.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandsOfRuneterra implements ModInitializer {

	public static final String MOD_ID = "landsofruneterra";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Runs the register function for all files that can write to oonsole
	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}