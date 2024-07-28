package me.localtrash.amethyst_wand;

import me.localtrash.amethyst_wand.item.ItemManager;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Starter implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Amethyst Wand");
	public static final String MOD_ID = "amethyst_wand";

    @Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("Hello Quilt world from {}! Stay fresh!", MOD_ID);

		ItemManager.initialize(mod);
    }
}
