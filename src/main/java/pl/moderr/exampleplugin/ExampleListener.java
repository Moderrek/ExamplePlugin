package pl.moderr.exampleplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ExampleListener implements Listener {

  @EventHandler
  public void exampleFunction(/*EVENT CLASS*/ /*argName*/) {

  }

  @EventHandler // <-- default priority is EventPriority.NORMAL
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();

    player.sendMessage(
        Component.text("Welcome to my server!")
        .color(NamedTextColor.GREEN)
        .hoverEvent(HoverEvent.showText(Component.text("Huh?")))
    );

    float volume = 1.0f;
    float pitch = 1.0f;
    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, volume,pitch);

    // Runs after 5s
    Bukkit.getScheduler().runTaskLater(ExamplePlugin.getInstance(), () -> {
      player.sendMessage(Component.text("Thanks for playing!"));
    }, 20L * 5L);
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onBlockPlace(BlockPlaceEvent event) {
    // lowest priority event
  }

}
