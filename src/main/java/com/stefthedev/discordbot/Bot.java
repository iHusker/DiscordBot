package com.stefthedev.discordbot;

import com.stefthedev.discordbot.commands.PingCommand;
import com.stefthedev.discordbot.listeners.CommandListener;
import com.stefthedev.discordbot.managers.CommandManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Bot {
    private static final String TOKEN = "Njc5ODY4MDM4ODUzNjg5NDMw.Xk3mgA.Uoh67X1fNlVOIN226HglSRTEGPA";

    public static void main(String[] args) throws LoginException, InterruptedException {
        CommandManager commandManager = new CommandManager();
        commandManager.initialise(
                new PingCommand()
        );

        JDABuilder builder = new JDABuilder(TOKEN);
        builder.addEventListeners(new CommandListener(commandManager));
        builder.setGuildSubscriptionsEnabled(false);
        builder.setChunkingFilter(ChunkingFilter.NONE);
        builder.setDisabledCacheFlags(EnumSet.of(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE));

        builder.build().awaitReady();
    }
}
