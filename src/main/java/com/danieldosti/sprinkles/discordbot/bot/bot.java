package com.danieldosti.sprinkles.discordbot.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
public class bot {

    //OAuth2 key goes here
    private static final String OAUTH_KEY = "";

    @Autowired
    public bot(CommandListener commandListener) throws LoginException {
        JDA jda = JDABuilder.createDefault(OAUTH_KEY).build();

        jda.addEventListener(commandListener);

        jda.getPresence().setActivity(Activity.watching("nothing :)"));
    }

}
