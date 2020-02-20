package com.stefthedev.discordbot.commands;

import com.stefthedev.discordbot.utilities.command.Command;
import com.stefthedev.discordbot.utilities.command.CommandExecutor;
import com.stefthedev.discordbot.utilities.command.SubCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Command(name = "core")
public class CoreCommand extends CommandExecutor {

    @Override
    public void execute(TextChannel textChannel, Member member) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor("Core");

        Method[] methods = getClass().getMethods();
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(methods).forEach(method -> {
            SubCommand subCommand = method.getAnnotation(SubCommand.class);
            if(subCommand != null) stringBuilder.append("- ").append(subCommand.name()).append("\n");
        });

        embedBuilder.setDescription(stringBuilder.toString());
        textChannel.sendMessage(embedBuilder.build()).queue();
    }

    @SubCommand(name = "ping")
    public void onPing(TextChannel textChannel, Member member) {
        long time = System.currentTimeMillis();

        textChannel.sendMessage("Pong!").queue(response ->
                response.editMessageFormat(":ping_pong: Pong: %d ms", System.currentTimeMillis() - time).queue()
        );
    }

    @SubCommand(name = "info")
    public void onMembers(TextChannel textChannel, Member member) {
        textChannel.sendMessage("No information to display at the moment.").queue();
    }
}
