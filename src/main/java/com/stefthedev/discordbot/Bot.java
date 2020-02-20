package com.stefthedev.discordbot;

import com.stefthedev.discordbot.commands.CoreCommand;
import com.stefthedev.discordbot.listeners.CommandListener;
import com.stefthedev.discordbot.managers.CommandManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Bot {
    private static final String TOKEN = "Njc5ODY4MDM4ODUzNjg5NDMw.Xk319w.J_J7xHbsQDGDNKDX6fMOdNdqMPA";

    public static void main(String[] args) throws LoginException, InterruptedException {
        CommandManager commandManager = new CommandManager();
        commandManager.initialise(new CoreCommand());

        JDABuilder builder = new JDABuilder(TOKEN);
        builder.addEventListeners(new CommandListener(commandManager));
        builder.setGuildSubscriptionsEnabled(false);
        builder.setChunkingFilter(ChunkingFilter.NONE);
        builder.setDisabledCacheFlags(EnumSet.of(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE));

        builder.build().awaitReady();
    }
}
