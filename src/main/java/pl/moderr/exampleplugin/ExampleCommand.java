package pl.moderr.exampleplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ExampleCommand implements CommandExecutor {
  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
    // commandSender universal

    ExamplePlugin.getInstance().getLogger().info("ExampleCommand used!");
    //   CLASS   ^   OBJECT    ^ method    ^ print info

    if (commandSender instanceof Player player) {
      // commandSender is Player
    }

    if (commandSender instanceof Player) {
      Player player = (Player) commandSender;
    } //              ^ CAST ^
    // ^ this same effect

    if (commandSender instanceof ConsoleCommandSender console) {
      // commandSender is Console
    }

    if (args.length == 1 && args[0].equalsIgnoreCase("reloadconfig")) {
      if (!commandSender.isOp()) return true;
      ExamplePlugin.getInstance().reloadConfig();
      commandSender.sendMessage("Plugin config reloaded.");
    }

    return false;
  }
}
