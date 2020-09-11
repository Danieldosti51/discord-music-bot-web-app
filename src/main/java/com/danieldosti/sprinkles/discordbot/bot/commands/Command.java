package com.danieldosti.sprinkles.discordbot.bot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public interface Command {

    String getToken();

    void perform(GuildMessageReceivedEvent event, List<String> args);

}
