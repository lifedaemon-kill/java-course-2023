package edu.project3;

import java.util.List;
import java.util.logging.LogRecord;
import java.util.stream.Stream;

public class AnalysisPipeline {
    /*
    Подсчитывать общее количество запросов
    Определять наиболее часто запрашиваемые ресурсы
    Определять наиболее часто встречающиеся коды ответа
    Рассчитывать средний размер ответа сервера
    */
    public static Stream<LogRecord> createStream(List<NGINXLog> log) {
        return null;
    }

}
