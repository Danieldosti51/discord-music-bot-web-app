package com.danieldosti.sprinkles.discordbot.web;

import com.danieldosti.sprinkles.discordbot.bot.util.Utilities;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

public class TrackBridge {
    public final String duration;
    public final String position;
    public final String title;
    public final String author;
    public final String uri;

    public TrackBridge(AudioTrack track) {
        duration = Utilities.convertToTime(track.getDuration());
        position = Utilities.convertToTime(track.getPosition());
        title = track.getInfo().title;
        author = track.getInfo().author;
        uri = track.getInfo().uri;
    }

}
