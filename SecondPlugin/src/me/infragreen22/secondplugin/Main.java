package me.infragreen22.secondplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginDescriptionFile pdf = getDescription();
        getLogger().info(pdf.getName() + " " + pdf.getVersion() + " был включен!");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile pdf = getDescription();
        getLogger().info(pdf.getName() + " " + pdf.getVersion() + " был выключен!");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("nv") && player.getPotionEffect(PotionEffectType.NIGHT_VISION) == null) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000000, 5));
            player.sendMessage(ChatColor.GREEN + "Ночное зрение включено для игрока " + player.getName() + "!");
            return true;
        }
        else if (label.equalsIgnoreCase("nv") && player.getPotionEffect(PotionEffectType.NIGHT_VISION) != null) {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            player.sendMessage(ChatColor.GREEN + "Ночное зрение выключено для игрока " + player.getName() + "!");
            return true;
        }
        return false;
    }
}
