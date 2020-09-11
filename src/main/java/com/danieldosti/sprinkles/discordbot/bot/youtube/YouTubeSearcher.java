package com.danieldosti.sprinkles.discordbot.bot.youtube;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class YouTubeSearcher {
    private static final String API_KEY = "AIzaSyBFBtyi5zRQ7qIcHeX-72Ybt0WdMfI8GT0";
    private static final long NUMBER_OF_VIDEOS_RETURNED = 1; //more results are unnecessary

    public String searchFor(String input){
        try {
            YouTube youtube = new YouTube.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    JacksonFactory.getDefaultInstance(),
                    null).setApplicationName("bob").build();

            List<SearchResult> results = initSearch(youtube, input);

            if (!results.isEmpty()) {
                return results.get(0).getId().getVideoId();
            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return "";
    }

    private List<SearchResult> initSearch(YouTube youtube, String input) throws IOException{
        return youtube.search()
                .list("id")
                .setQ(input)
                .setMaxResults(NUMBER_OF_VIDEOS_RETURNED)
                .setType("video")
                .setFields("items(id)")
                .setKey(API_KEY)
                .execute()
                .getItems();
    }

}
