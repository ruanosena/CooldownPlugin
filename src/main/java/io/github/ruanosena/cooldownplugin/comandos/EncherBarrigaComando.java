package io.github.ruanosena.cooldownplugin.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class EncherBarrigaComando implements CommandExecutor {
    private final HashMap<UUID, Long> cooldown;

    public EncherBarrigaComando() {
        this.cooldown = new HashMap<>();
    }
    @Override
    public boolean onCommand(CommandSender invocador, Command comando, String s, String[] strings) {
        if (invocador instanceof Player jogador) {
            if (comando.getName().equalsIgnoreCase("encherbarriga")) {
                if (strings.length == 0) {
                    UUID uuid = jogador.getUniqueId();
                    long agora = System.currentTimeMillis();
                    if (!cooldown.containsKey(uuid) || (agora - cooldown.get(uuid)) >= 10000) {
                        cooldown.put(uuid, agora);
                        jogador.setFoodLevel(20);
                        jogador.sendMessage("Você encheu a barriga, agora está de buchinho cheio!");
                    } else {
                        jogador.sendMessage("Espere mais %d ms".formatted(10000 - (agora - cooldown.get(uuid))));
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
