package com.danieldosti.sprinkles.discordbot.web;

import com.danieldosti.sprinkles.discordbot.bot.music.PlayerManager;
import com.danieldosti.sprinkles.discordbot.bot.music.TrackScheduler;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import static com.danieldosti.sprinkles.discordbot.bot.util.Utilities.convertToList;

@Controller
@RequestMapping("/queue")
public class TrackQueueWebController {

    @GetMapping
    public String getQueue(@RequestParam(value="id")long id, Model model) {
        TrackScheduler scheduler = PlayerManager.getInstance().getGuildMusicManager(id).scheduler;
        BlockingQueue<AudioTrack> queue = scheduler.getQueue();
        List<TrackBridge> trackList = convertToList(queue);
        TrackBridge currentTrack = scheduler.getCurrentTrack() == null ? null : new TrackBridge(scheduler.getCurrentTrack());
        if (currentTrack == null && queue.size() == 0) return "notfound";
        model.addAttribute("currentTrack", currentTrack);
        model.addAttribute("tracks", trackList);
        return "queue";
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch() {
        return "invalid";
    }

    @ExceptionHandler(NullPointerException.class)
    public String handleNullPointer() {
        return "notfound";
    }
}
