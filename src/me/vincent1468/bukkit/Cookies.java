package me.vincent1468.bukkit;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Cookies implements Listener {

	public FreeCookies instance;
	public Cookies(FreeCookies instance) {
		this.instance = instance;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Config.usePermissions()) {
			if(!e.getPlayer().hasPermission("freecookies.onjoin")) return;
		}
		if(Config.giveCookieOnJoin()) {
			e.getPlayer().getInventory().addItem(new ItemStack(Material.COOKIE, Config.getAmount()));
		}
	}
}
