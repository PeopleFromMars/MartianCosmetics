package net.martianz.martiancosmetics.item;

import net.martianz.martiancosmetics.MartianCosmetics;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MartianCosmetics.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MartianCosmetics.MODID);


    public static final DeferredItem<RunOfMenaceItem> RUNE_OF_MENACE = ITEMS.register("rune_of_menace", () -> new RunOfMenaceItem(new Item.Properties()) );


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("cosmetics_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.martiancosmetics.cosmetics_tab")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> RUNE_OF_MENACE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(RUNE_OF_MENACE.get());
            }).build());

    public static void register(IEventBus modEventBus){
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
