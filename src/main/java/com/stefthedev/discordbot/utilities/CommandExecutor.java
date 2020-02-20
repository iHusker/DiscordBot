package com.stefthedev.discordbot.utilities;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class CommandExecutor {

    private final String name;
    private final int length;
    private Permission[] permissions;

    public CommandExecutor() {
        CommandAnnotation commandAnnotation = getClass().getAnnotation(CommandAnnotation.class);
        this.name = commandAnnotation.name();
        this.length = commandAnnotation.length();
        this.permissions = commandAnnotation.permission();
    }

    public abstract void execute(MessageReceivedEvent event, String[] args);

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public Permission[] getPermissions() {
        return permissions;
    }
}
