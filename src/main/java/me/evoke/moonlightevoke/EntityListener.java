package me.evoke.moonlightevoke;

import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityListener implements Listener {

     @EventHandler
    public void onEntityRightClick(PlayerInteractEntityEvent event){
         Player player = event.getPlayer();
         Entity entity = event.getRightClicked();

         if(entity instanceof Cow && entity.hasMetadata("MoonlightEvoke")){
             if(!player.hasPermission("moonlightevoke.cow.use")){
                player.sendMessage("You do not have this permission");

                return;
             }
             Cow cow = (Cow) entity;

             cow.getWorld().createExplosion(cow.getLocation(), 10f);
         }
     }

}
