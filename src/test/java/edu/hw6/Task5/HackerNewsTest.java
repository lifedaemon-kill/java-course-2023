package edu.hw6.Task5;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static edu.hw6.Task5.HackerNews.hackerNewsTopStories;
import static edu.hw6.Task5.HackerNews.news;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class HackerNewsTest {
    @Test
    @DisplayName("hackerNewsTopStories")
    void hackerNewsTopStoriesTest(){
        long[] result = hackerNewsTopStories();

        log.info(Arrays.toString(result));

        assertThat(result).isNotEmpty();
    }

    @Test
    @DisplayName("name of News")
    void newsTest(){
        String newsTitle = news(37570037);

        log.info(newsTitle);

        assertThat(newsTitle).isEqualTo("JDK 21 Release Notes");
    }

}
