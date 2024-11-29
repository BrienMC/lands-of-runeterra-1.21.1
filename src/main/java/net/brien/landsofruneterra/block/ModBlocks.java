package net.brien.landsofruneterra.block;

import net.brien.landsofruneterra.LandsOfRuneterra;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block HEXTECH_ORE = registerBlock("hextech_ore", new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block HEXTECH_DEEPSLATE_ORE = registerBlock("hextech_deepslate_ore", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(LandsOfRuneterra.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(LandsOfRuneterra.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        LandsOfRuneterra.LOGGER.info("Registering Mod Blocks for " + LandsOfRuneterra.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.HEXTECH_ORE);
            entries.add(ModBlocks.HEXTECH_DEEPSLATE_ORE);
        });
    }
}