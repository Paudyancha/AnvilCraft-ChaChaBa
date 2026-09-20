package dev.anvilcraft.ccb.data.lang;

import dev.anvilcraft.ccb.config.CCBServerConfig;
import dev.anvilcraft.lib.v2.config.ConfigData;
import dev.anvilcraft.lib.v2.registrum.providers.RegistrumLangProvider;

public class LangHandler {
    public static void init(RegistrumLangProvider provider) {
        ConfigData.readConfigClass(provider, CCBServerConfig.class);

    }
}
