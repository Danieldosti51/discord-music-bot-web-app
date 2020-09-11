package com.danieldosti.sprinkles.discordbot.bot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandListener extends ListenerAdapter {

    private final CommandManager manager;
    private static final String COMMAND_PREFIX = "!";

    @Autowired
    public CommandListener(CommandManager manager) {
        this.manager = manager;
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String message = event.getMessage().getContentRaw();
        if (message.startsWith(COMMAND_PREFIX)) {
            manager.performCommand(event);
        }
    }

}
