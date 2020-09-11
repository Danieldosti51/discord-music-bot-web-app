package com.danieldosti.sprinkles.discordbot.bot.commands;

import com.danieldosti.sprinkles.discordbot.bot.music.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class ClearCommand implements Command {

    @Override
    public String getToken() {
        return "clear";
    }

    @Override
    public void perform(GuildMessageReceivedEvent event, List<String> args) {
        PlayerManager manager = PlayerManager.getInstance();
        manager.clearTracks(event.getChannel());
        event.getChannel().sendMessage("okay, clearing queue.").queue();
    }

}
