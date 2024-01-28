package pl.moderr.exampleplugin;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ExampleCommandTabComplete implements CommandExecutor, TabCompleter {

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
    if (args.length == 0) {
      sender.sendMessage("Not enough arguments!");
      return false;
    }
    String option = args[0];
    if (option.equalsIgnoreCase("hello")) {
      sender.sendMessage("Hello " + sender.getName().toLowerCase() + "!");
      return true;
    }
    if (option.equalsIgnoreCase("bye")) {
      sender.sendMessage("Bye bye " + sender.getName().toLowerCase() + "!");
      return true;
    }
    sender.sendMessage("Invalid argument!");
    return false;
  }

  @Override
  public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
    return List.of("hello", "bye");
  }

}
