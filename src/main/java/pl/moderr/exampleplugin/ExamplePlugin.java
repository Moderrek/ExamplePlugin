package pl.moderr.exampleplugin;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

public final class ExamplePlugin extends JavaPlugin {

    private final Logger logger = getSLF4JLogger();

    // Singleton
    private static ExamplePlugin instance;
    public static ExamplePlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        // ^ Check ExampleCommand
        long start = System.currentTimeMillis();

        // Load config
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        getConfig().options().parseComments(true);
        saveConfig();

        logger.info("Magic number = {}", getConfig().getDouble("magic-number"));

        // Listener register
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ExampleListener(), this);
        /* ... */

        // Command register
        getCommand("example").setExecutor(new ExampleCommand());
        // ^ command can be null if it is not saved in plugin.yml
        // so no command in plugin.yml = Plugin Error
        // https://www.spigotmc.org/wiki/plugin-yml/

        // Bukkit Tasks
        long period = 20L * 60L;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            Bukkit.broadcast(Component.text("[SERVER] Minute task"));
        }, 0,period);

        long delay = 20L * 5L;
        Bukkit.getScheduler().runTaskLater(this, () -> {
            Bukkit.broadcast(Component.text("[SERVER] After 5s"));
        }, delay);
        // ^ This is not delay but separate task that will be performed after `N` ticks

        long end = System.currentTimeMillis() - start;
        logger.info("Plugin enabled in {}ms :)", end);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfig();
        logger.info("Plugin disabled");
    }
}
