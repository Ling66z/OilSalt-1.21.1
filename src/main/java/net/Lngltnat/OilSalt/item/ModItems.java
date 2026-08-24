package net.Lngltnat.OilSalt.item;

import net.Lngltnat.OilSalt.OilSalt;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OilSalt.MODID);

    public static final DeferredItem<Item> SHIT = ITEMS.register("shit",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
