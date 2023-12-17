package edu.hw6.Task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HackerNews {
    private HackerNews() {
    }

    final static String TARGET_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";

    private static String getURLFromId(long id) {
        return "https://hacker-news.firebaseio.com/v0/item/" + id + ".json";
    }

    private static String getResponse(String url) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private static String getResponse(long id) {
        String url = getURLFromId(id);
        return getResponse(url);
    }

    public static long[] hackerNewsTopStories() {
        String str = getResponse(TARGET_URL);
        long[] result;
        try {
            assert str != null;
            str = str.substring(1, str.length() - 1); //обрезали квадратные скобки
            String[] arr = str.split(",");
            result = new long[arr.length];

            for (int i = 0; i < arr.length; i++) {
                result[i] = Long.parseLong(arr[i]);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            result = new long[0];
        }
        return result;
    }

    public static String news(long id) {
        String response = getResponse(id);

        //pattern = "title":"JDK 21 Release Notes"
        Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(response);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
