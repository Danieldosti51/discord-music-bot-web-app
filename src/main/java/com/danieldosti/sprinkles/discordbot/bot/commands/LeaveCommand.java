package com.danieldosti.sprinkles.discordbot.bot.commands;

import com.danieldosti.sprinkles.discordbot.bot.music.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.List;

public class LeaveCommand implements Command {

    @Override
    public String getToken() {
        return "leave";
    }

    @Override
    public void perform(GuildMessageReceivedEvent event, List<String> args) {
        AudioManager audioManager = event.getGuild().getAudioManager();
        if(!audioManager.isConnected()) {
            event.getChannel().sendMessage("not connected to a voice channel").queue();
            return;
        }
        PlayerManager manager = PlayerManager.getInstance();
        manager.clearTracks(event.getChannel());
        audioManager.closeAudioConnection();
        event.getChannel().sendMessage("okay, disconnected").queue();
    }
}
