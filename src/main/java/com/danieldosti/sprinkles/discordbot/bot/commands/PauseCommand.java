package com.danieldosti.sprinkles.discordbot.bot.commands;

import com.danieldosti.sprinkles.discordbot.bot.music.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class PauseCommand implements Command {

    @Override
    public String getToken() {
        return "pause";
    }

    @Override
    public void perform(GuildMessageReceivedEvent event, List<String> args) {
        PlayerManager manager = PlayerManager.getInstance();
        manager.pauseTrack(event.getChannel());
    }
}
