package com.danieldosti.sprinkles.discordbot.bot.util;

import com.danieldosti.sprinkles.discordbot.web.TrackBridge;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public static boolean isUrl(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static String convertToTime(long duration) {
        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(duration),
                TimeUnit.MILLISECONDS.toMinutes(duration)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)),
                TimeUnit.MILLISECONDS.toSeconds(duration)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }

    public static List<TrackBridge> convertToList(Queue<AudioTrack> queue) {
        List<TrackBridge> result = new ArrayList<>();
        for (AudioTrack track : queue) {
            result.add(new TrackBridge(track));
        }
        return result;
    }

}
