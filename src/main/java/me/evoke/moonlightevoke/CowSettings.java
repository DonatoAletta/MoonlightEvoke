package me.evoke.moonlightevoke;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;

import java.io.File;

public class CowSettings {
    private final static CowSettings istance = new CowSettings();

    private File file;
    private YamlConfiguration config;
    private EntityType explodingType;


    private CowSettings(){

    }



    public void laod(){
        file = new File(MoonlightEvoke.getInstance().getDataFolder(), "settings.yml");

        if(!file.exists()){
            MoonlightEvoke.getInstance().saveResource("settings.yml",false);
        }

        config = new YamlConfiguration();
        config.options().parseComments(true);
        try{
            config.load(file);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        explodingType = EntityType.valueOf(config.getString("Explosion.entity-type"));
    }

    public void save(){
        try{
            config.save(file);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void path(String path, Object value){
        config.set(path,value);
        save();
    }

    public EntityType getExplodingType() {
        return explodingType;
    }

    public void setExplodingType(EntityType explodingType) {
        this.explodingType = explodingType;

    }
}

