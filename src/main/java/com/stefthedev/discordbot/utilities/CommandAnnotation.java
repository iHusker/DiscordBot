package com.stefthedev.discordbot.utilities;

import net.dv8tion.jda.api.Permission;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandAnnotation {
    String name();
    int length() default 1;
    Permission[] permission() default { Permission.MESSAGE_WRITE };
}
