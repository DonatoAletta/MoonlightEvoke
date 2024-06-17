package me.evoke.moonlightevoke;

import org.bukkit.plugin.java.JavaPlugin;

public final class MoonlightEvoke extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntityListener(),this);
        getCommand("cow").setExecutor(new CowCannon());

    }

    @Override
    public void onDisable() {
        getLogger().info("@ MoonlightEvoke has been disabled");
    }

    public static MoonlightEvoke getInstance(){
        return getPlugin(MoonlightEvoke.class);
    }
}
