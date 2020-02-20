package com.stefthedev.discordbot.utilities.command;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SubCommand {
    String name();
}
