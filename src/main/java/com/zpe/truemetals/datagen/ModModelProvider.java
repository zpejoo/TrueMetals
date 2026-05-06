package com.zpe.truemetals.datagen;

import com.zpe.truemetals.Blocks.ModBlocks;
import com.zpe.truemetals.Item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output){
        super(output);
    }


    //GERADOR DOS BLOCOS
    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators)  {
        blockModelGenerators.createTrivialCube(ModBlocks.STEEL_BLOCK);
    }

    //GERADOR DOS ITENS
    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators){
        itemModelGenerators.generateFlatItem(ModItems.ROSEGOLD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.STEEL, ModelTemplates.FLAT_ITEM);
    }
}
