package io.github.ruanosena.cooldownplugin;

import io.github.ruanosena.cooldownplugin.comandos.EncherBarrigaComando;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CooldownPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Objects.requireNonNull(this.getCommand("encherbarriga")).setExecutor(new EncherBarrigaComando());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
