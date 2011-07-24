package com.Baummann.SetRank;

import java.util.LinkedHashSet;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.nijiko.permissions.Entry;
import com.nijiko.permissions.Group;
import com.nijiko.permissions.PermissionHandler;
import com.nijiko.permissions.User;
import com.nijikokun.bukkit.Permissions.Permissions;


public class SetRankAPI {
    public static PermissionHandler permissionHandler;
    
    public SetRankAPI(Plugin permissions) {
    	permissionHandler = ((Permissions) permissions).getHandler();
    }
    
    public static String getGroup(Player player) {
    	User user = permissionHandler.getUserObject(player.getWorld().getName(), player.getName());
    	LinkedHashSet<Entry> groups = user.getParents();
    	String str = "";
    	for (Entry group : groups) {
    		str = group.getName();
    	}
        return str;
    }
    
    private void removeGroup(Player player, String group) {
    	User user = permissionHandler.getUserObject(player.getWorld().getName(), player.getName());
    	Group g = permissionHandler.getGroupObject(player.getWorld().getName(), group);
    	user.removeParent(g);
    }
    
    private void addGroup(Player player, String group) {
    	User user = permissionHandler.getUserObject(player.getWorld().getName(), player.getName());
    	Group g = permissionHandler.getGroupObject(player.getWorld().getName(), group);
    	user.addParent(g);
    }
    
    public void setGroup(Player player, String group) {
    	removeGroup(player, group);
    	addGroup(player, group);
    }
    
    public boolean canModifyGroupOrUser(Player player, String group) {
    	User user = permissionHandler.getUserObject(player.getWorld().getName(), player.getName());
    	Group g = permissionHandler.getGroupObject(player.getWorld().getName(), group);
    	if (user == null)
    		return false;
    	if (g == null)
    		return false;
    	return true;
    }
}
