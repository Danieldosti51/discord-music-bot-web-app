package com.danieldosti.sprinkles.discordbot.bot.commands;

import com.danieldosti.sprinkles.discordbot.bot.music.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class ResumeCommand implements Command {

    @Override
    public String getToken() {
        return "resume";
    }

    @Override
    public void perform(GuildMessageReceivedEvent event, List<String> args) {
        PlayerManager manager = PlayerManager.getInstance();
        manager.resumeTrack(event.getChannel());
    }
}
