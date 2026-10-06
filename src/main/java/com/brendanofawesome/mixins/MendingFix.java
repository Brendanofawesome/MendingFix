package com.brendanofawesome.mixins.mendingFix;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MendingFix implements ModInitializer {
    public static final String MOD_ID = "mendingfix";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("MendingFix initialized");
    }
}
