package dev.EX;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    Logger log = getLogger();
    static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        log.info("ZZDLib Enabled");
        log.info("Developed by BM");


    }

    public static Main getInstance() {
        return instance;
    }





}