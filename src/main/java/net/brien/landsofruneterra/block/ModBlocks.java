package net.brien.landsofruneterra.block;

import net.brien.landsofruneterra.LandsOfRuneterra;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    // Handles all Lands of Runeterra blocks.

    // Keep this for placeholder to copy and paste
    // public static final Block HEXITE_ORE = registerBlock("hexite_ore", new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block HEXITE_ORE = registerBlock("hexite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block HEXITE_DEEPSLATE_ORE = registerBlock("hexite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


    // Helper method for setting up new blocks in the world
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(LandsOfRuneterra.MOD_ID, name), block);
    }

    // Helper method for setting up the inventory item version of the block
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(LandsOfRuneterra.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    // Prints to logger that this file is being read
    public static void registerModBlocks() {
        LandsOfRuneterra.LOGGER.info("Registering Mod Blocks for " + LandsOfRuneterra.MOD_ID);

        // Adds modded blocks to vanilla creative mode tabs
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.HEXITE_ORE);
            entries.add(ModBlocks.HEXITE_DEEPSLATE_ORE);
        });
    }
}
