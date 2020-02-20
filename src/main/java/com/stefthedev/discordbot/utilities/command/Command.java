package com.stefthedev.discordbot.utilities.command;

import net.dv8tion.jda.api.Permission;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String name();
    int length() default 1;
    Permission[] permission() default { Permission.MESSAGE_WRITE };
}
