package me.megalodonbait.chatNickPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChatNickPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("nick").setExecutor(new NickCommand());
    }
}