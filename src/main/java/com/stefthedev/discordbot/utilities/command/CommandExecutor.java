package com.stefthedev.discordbot.utilities.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

public abstract class CommandExecutor {

    private Command command;

    public CommandExecutor() {
        this.command = getClass().getAnnotation(Command.class);
    }

    public abstract void execute(TextChannel textChannel, Member member);

    public Command getCommand() {
        return command;
    }
}
