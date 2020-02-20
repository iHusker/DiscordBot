package com.stefthedev.discordbot.managers;

import com.stefthedev.discordbot.utilities.CommandExecutor;
import com.stefthedev.discordbot.utilities.general.Manager;

import java.util.Arrays;

public class CommandManager extends Manager<CommandExecutor> {

    public void initialise(CommandExecutor... commandExecutors) {
        Arrays.asList(commandExecutors).forEach(this::add);
    }
}
