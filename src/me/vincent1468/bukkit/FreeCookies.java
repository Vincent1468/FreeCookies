package me.vincent1468.bukkit;

import java.util.logging.Logger;

import me.vincent1468.bukkit.Commands.CookieCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class FreeCookies extends JavaPlugin {

	public void log(String msg) {
		Logger.getLogger("Minecraft").info("[FreeCookies] " + msg);
	}
	public void onEnable() {
		Config.load(this);
		getServer().getPluginManager().registerEvents(new Cookies(this), this);
		getCommand("cookie").setExecutor(new CookieCommand(this));
		log("has been enabled!");
	}
}
