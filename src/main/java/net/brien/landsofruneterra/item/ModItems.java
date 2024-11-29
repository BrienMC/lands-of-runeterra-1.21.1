package net.brien.landsofruneterra.item;

import net.brien.landsofruneterra.LandsOfRuneterra;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item INFINITY_EDGE = registerItem("infinity_edge", new Item(new Item.Settings()));
    public static final Item UNPOWERED_INFINITY_EDGE = registerItem("unpowered_infinity_edge", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LandsOfRuneterra.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LandsOfRuneterra.LOGGER.info("Registering Mod Items for " + LandsOfRuneterra.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(INFINITY_EDGE);
            entries.add(UNPOWERED_INFINITY_EDGE);
        });
    }
}
