package com.zpe.truemetals;

import com.zpe.truemetals.Blocks.ModBlockEntity;
import com.zpe.truemetals.Blocks.ModBlocks;
import com.zpe.truemetals.Blocks.ModMenuType;
import com.zpe.truemetals.Blocks.custom.BlockMenu.KilnBlockScreen;
import com.zpe.truemetals.Blocks.custom.KilnBlock;
import com.zpe.truemetals.Item.ModItemGroups;
import com.zpe.truemetals.Item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.gui.screens.MenuScreens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueMetals implements ModInitializer {
	public static final String MOD_ID = "truemetals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlockEntity.registerModBlockEntity();
		ModItemGroups.registerItemGroup();
		ModItems.registerModItem();
		ModBlocks.registerModBlocks();
		MenuScreens.register(ModMenuType.KILN_BLOCK, KilnBlockScreen::new);
	}
}