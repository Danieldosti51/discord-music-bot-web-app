package com.danieldosti.sprinkles.discordbot.web;

import com.danieldosti.sprinkles.discordbot.bot.music.PlayerManager;
import com.danieldosti.sprinkles.discordbot.bot.music.TrackScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.danieldosti.sprinkles.discordbot.bot.util.Utilities.convertToList;

@RestController
public class TrackQueueWebServiceController {

    @GetMapping("api/queue")
    public List<TrackBridge> getQueue(@RequestParam(value="id")long id) {
        try {
            TrackScheduler scheduler = PlayerManager.getInstance().getGuildMusicManager(id).scheduler;
            return convertToList(scheduler.getQueue());
        } catch (NullPointerException e) {
            return null;
        }
    }

    @GetMapping("api/current")
    public TrackBridge getCurrentTrack(@RequestParam(value="id")long id) {
        try {
            TrackScheduler scheduler = PlayerManager.getInstance().getGuildMusicManager(id).scheduler;
            return new TrackBridge(scheduler.getCurrentTrack());
        } catch (NullPointerException e) {
            return null;
        }
    }

}
