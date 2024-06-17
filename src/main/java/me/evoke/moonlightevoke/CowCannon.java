package me.evoke.moonlightevoke;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CowCannon implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        if(args.length > 1){
            sender.sendMessage("Out of bound exception");
            return false;
        }
        Player player = (Player) sender;
        Cow cow = player.getWorld().spawn(player.getLocation(), Cow.class);

        if(args.length == 1 && args[0].equalsIgnoreCase("Baby")){
            cow.setBaby();
        }

        cow.setMetadata("MoonlightEvoke", new FixedMetadataValue(MoonlightEvoke.getInstance(), true));
        cow.setCustomName(ChatColor.DARK_PURPLE + "Leviatano Calmo");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            return Arrays.asList("baby");
        }
        return new ArrayList<>();
    }
}
