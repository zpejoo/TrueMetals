package com.zpe.truemetals;

import com.zpe.truemetals.Blocks.ModBlocks;
import com.zpe.truemetals.Item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueMetals implements ModInitializer {
	public static final String MOD_ID = "truemetals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItem();
		ModBlocks.registerModBlocks();
	}
}