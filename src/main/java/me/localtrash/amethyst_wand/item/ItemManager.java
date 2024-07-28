package me.localtrash.amethyst_wand.item;

import me.localtrash.amethyst_wand.Starter;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;


public class ItemManager {
	public static final Item AMETHYST_WAND = registry(
		new AmethystWand(new Item.Settings()),
		"amethyst_wand"
	);

	private static Item registry(Item item, String id) {
		Identifier ident = Identifier.of(Starter.MOD_ID, id);

		return Registry.register(Registries.ITEM, ident, item);
	}

	public static void initialize(ModContainer mod) {
		Starter.LOGGER.info("Initializing Item");

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS_AND_UTILITIES).register((group) -> {
			group.addItem(AMETHYST_WAND);
		});
	}
}
