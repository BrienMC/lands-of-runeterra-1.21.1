package net.brien.landsofruneterra.item;

import net.brien.landsofruneterra.LandsOfRuneterra;
import net.brien.landsofruneterra.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup LANDS_OF_RUNETERRA_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LandsOfRuneterra.MOD_ID, "lands_of_runeterra_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.HEXTECH_ORE))
                    .displayName(Text.translatable("itemgroup.landsofruneterra.lands_of_runeterra_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.HEXTECH_ORE);
                        entries.add(ModBlocks.HEXTECH_DEEPSLATE_ORE);
                    })
                    .build());

    public static final ItemGroup LANDS_OF_RUNETERRA_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LandsOfRuneterra.MOD_ID, "lands_of_runeterra_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.INFINITY_EDGE))
                    .displayName(Text.translatable("itemgroup.landsofruneterra.lands_of_runeterra_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.INFINITY_EDGE);
                        entries.add(ModItems.UNPOWERED_INFINITY_EDGE);
                    })
                    .build());

    public static void registerItemGroups() {
        LandsOfRuneterra.LOGGER.info("Registering Item Groups for " + LandsOfRuneterra.MOD_ID);
    }
}
