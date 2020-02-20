package com.stefthedev.discordbot.commands;

import com.stefthedev.discordbot.utilities.CommandAnnotation;
import com.stefthedev.discordbot.utilities.CommandExecutor;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@CommandAnnotation(name = "ping")
public class PingCommand extends CommandExecutor {

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        long time = System.currentTimeMillis();

        event.getMessage().getTextChannel().sendMessage("Pong!").queue(response ->
                response.editMessageFormat(":ping_pong: Pong: %d ms", System.currentTimeMillis() - time).queue()
        );
    }
}
