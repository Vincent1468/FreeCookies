package me.vincent1468.bukkit.Commands;

import me.vincent1468.bukkit.Config;
import me.vincent1468.bukkit.FreeCookies;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CookieCommand implements CommandExecutor {
	public FreeCookies instance;
	public CookieCommand(FreeCookies instance) {
		this.instance = instance;
	}
	private String prefix = ChatColor.YELLOW + "[FreeCookies] ";
    
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players can use this!");
			return false;
		}
		Player p = (Player) sender;
		if(args.length == 0) {
			if(!p.hasPermission("freecookies.cookie")) {
				p.sendMessage(ChatColor.RED + "You don't have permission.");
				return false;
			}
			p.getInventory().addItem(new ItemStack(Material.COOKIE, Config.getAmount()));
			p.sendMessage(prefix + ChatColor.GREEN + "Enjoy your cookie!");
		} else if(args.length == 1 && args[0].equalsIgnoreCase("help")) {
			p.sendMessage(prefix + ChatColor.GREEN + "----FreeCookies----");
			p.sendMessage(prefix + ChatColor.GREEN + "Commands:");
			p.sendMessage(prefix + ChatColor.GREEN + "/cookie " + ChatColor.DARK_GREEN + "Gives you cookies!");
			p.sendMessage(prefix + ChatColor.GREEN + "/cookie help " + ChatColor.DARK_GREEN + "Shows this menu.");
			p.sendMessage(prefix + ChatColor.GREEN + "/cookie reload " + ChatColor.DARK_GREEN + "Reloads the configuration file.");
			p.sendMessage(prefix + ChatColor.GREEN + "");
			if(Config.giveCookieOnJoin()) {
				p.sendMessage(prefix + ChatColor.GREEN + "Cookie on join: Yes");
			} else {
				p.sendMessage(prefix + ChatColor.GREEN + "Cookie on join: " + ChatColor.RED + "No");
			}
			p.sendMessage(prefix + ChatColor.GREEN + "----By Vincent1468----");
		} else if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {
			if(!p.hasPermission("freecookies.reload")) {
				p.sendMessage(ChatColor.RED + "You don't have permission.");
				return false;
			}
			Config.reload(instance);
			p.sendMessage(prefix + ChatColor.GREEN + "Reloaded!");
		}
		return false;
	}
}
