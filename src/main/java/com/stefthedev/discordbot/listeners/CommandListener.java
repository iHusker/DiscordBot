package com.stefthedev.discordbot.listeners;

import com.stefthedev.discordbot.managers.CommandManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class CommandListener extends ListenerAdapter {

    private final CommandManager commandManager;

    public CommandListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        String[] arguments = event.getMessage().getContentRaw().split(" ");
        commandManager.asSet().forEach(commandExecutor -> {
            if(arguments[0].equalsIgnoreCase("!" + commandExecutor.getName().split(" ")[0])) {
                if(event.getMember() == null) return;
                if(arguments.length > commandExecutor.getLength()) {
                    event.getMessage().getTextChannel().sendMessage("Usage: " + commandExecutor.getName()).queue();
                } else {
                    if(event.getMember().hasPermission(commandExecutor.getPermissions())) {
                        event.getMessage().delete().reason("command");
                        commandExecutor.execute(event, arguments);
                    }
                }
            }
        });
    }
}
