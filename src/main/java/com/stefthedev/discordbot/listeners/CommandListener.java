package com.stefthedev.discordbot.listeners;

import com.stefthedev.discordbot.managers.CommandManager;
import com.stefthedev.discordbot.utilities.command.SubCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CommandListener extends ListenerAdapter {

    private final CommandManager commandManager;

    public CommandListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        String[] arguments = event.getMessage().getContentRaw().split(" ");
        commandManager.asSet().forEach(commandExecutor -> {
            if(arguments[0].equalsIgnoreCase("!" + commandExecutor.getCommand().name().split(" ")[0])) {
                if(event.getMember() == null) return;
                if(arguments.length == 1) {
                    commandExecutor.execute(event.getTextChannel(), event.getMember());
                } else {
                    Arrays.asList(commandExecutor.getClass().getMethods()).forEach(method -> {
                        SubCommand subCommand = method.getAnnotation(SubCommand.class);
                        if (subCommand != null) {
                            try {
                                if(arguments[1].equalsIgnoreCase(subCommand.name())) {
                                    method.invoke(commandExecutor, event.getTextChannel(), event.getMember());
                                }
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                event.getMessage().delete().reason("command");
            }
        });
    }
}
