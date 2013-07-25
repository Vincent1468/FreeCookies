package me.vincent1468.bukkit;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

	public static void load(FreeCookies plugin) {
		FileConfiguration config = plugin.getConfig();
		
		config.options().header("FreeCookies Configuration File");
		
		config.addDefault("GiveCookieOnJoin", true);
		config.addDefault("use-permissions", false);
		config.addDefault("amount", 1);
		
		config.options().copyDefaults(true);
		plugin.saveConfig();
		
		giveCookieOnJoin = config.getBoolean("GiveCookieOnJoin");
		usePermissions = config.getBoolean("use-permissions");
		amount = config.getInt("amount");
	}
	public static void reload(FreeCookies plugin) {
		plugin.reloadConfig();
	}
	public static Boolean giveCookieOnJoin() {
		return giveCookieOnJoin;
	}
	public static Boolean usePermissions() {
		return usePermissions;
	}
	public static Integer getAmount() {
		return amount;
	}
	private static Boolean giveCookieOnJoin;
	private static Boolean usePermissions;
	private static Integer amount;
}
