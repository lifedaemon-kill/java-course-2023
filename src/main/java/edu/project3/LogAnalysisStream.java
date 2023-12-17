package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogAnalysisStream {

    @Getter private static String text = "";
    private final List<LogRecord> logs;

    private LogAnalysisStream(List<LogRecord> logs) {
        this.logs = logs;
    }

    public static LogAnalysisStream createStream(List<LogRecord> logs) {
        return new LogAnalysisStream(logs);
    }

    public LogAnalysisStream generalInfo() {
        String header = "| %-24s | %10s |\n";
        text += "####### Общая информация\n"
                + "|          Метрика         |   Значение |\n"
                + "|:------------------------:|:----------:|\n";

        int numberOfRequests = logs.size();

        OffsetDateTime minDate = logs.stream().min((o1, o2) -> {
            if (o1.timeLocal().isBefore(o2.timeLocal())) {
                return 1;
            }
            if (o1.timeLocal().isEqual(o2.timeLocal())) {
                return 0;
            } else {
                return -1;
            }
        }).get().timeLocal();

        OffsetDateTime maxDate = logs.stream().max((o1, o2) -> {
            if (o2.timeLocal().isBefore(o1.timeLocal())) {
                return 1;
            }
            if (o1.timeLocal().isEqual(o2.timeLocal())) {
                return 0;
            } else {
                return -1;
            }
        }).get().timeLocal();

        long averageResponse = 0L;
        long countOfZeroByte = 0L;

        for (var item : logs) {
            if (item.BodyBytesSent() == 0) {
                countOfZeroByte += 1;
            } else {
                averageResponse += item.BodyBytesSent();
            }
        }

        text +=
            header.formatted("Количество запросов", numberOfRequests)
            + header.formatted("Минимальная дата", minDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
            + header.formatted("Максимальная дата", maxDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
            + header.formatted("Средний размер ответа", averageResponse / numberOfRequests + "b")
            + header.formatted("Средний размер без нулей", averageResponse / (numberOfRequests - countOfZeroByte) + "b")
            + "\n";

        return this;
    }

    public LogAnalysisStream serverResponseCodes() {
        Map<Integer, Integer> map = new HashMap<>();


        for (var item : this.logs) {
            if (map.containsKey(item.response())) {
                map.put(item.response(), map.get(item.response()) + 1);
            } else {
                map.put(item.response(), 1);
            }
        }

        //Sort
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        map.clear();

        String header = "| %3s |%12s | %-50s |\n";
        text += "####### Коды ответа\n" +
                header.formatted("Код", "Количество", "Расшифровка")
                + "|:---:|:" + "-".repeat(11) + ":|:" + "-".repeat(50) + ":|\n";
        Map<Integer, String> codeMap = new HashMap<>() {
        };
        {
            codeMap.put(100, "Continue («продолжайте»)");
            codeMap.put(101, "Switching Protocols («переключение протоколов»)");
            codeMap.put(102, "Processing («идёт обработка»)");
            codeMap.put(103, "Early Hints («ранняя метаинформация»)");
            codeMap.put(200, "OK («хорошо»)");
            codeMap.put(201, "Created («создано»)");
            codeMap.put(202, "Accepted («принято»)");
            codeMap.put(203, "Non-Authoritative Information («информация не авторитетна»)");
            codeMap.put(204, "No Content («нет содержимого»)");
            codeMap.put(205, "Reset Content («сбросить содержимое»)");
            codeMap.put(206, "Partial Content («частичное содержимое»)");
            codeMap.put(207, "Multi-Status («многостатусный»)");
            codeMap.put(208, "Already Reported («уже сообщалось»)");
            codeMap.put(226, "IM Used («использовано IM»)");
            codeMap.put(300, "Multiple Choices («множество выборов»)");
            codeMap.put(301, "Moved Permanently («перемещено навсегда»)");
            codeMap.put(302, "Moved Temporarily («перемещено временно»)");
            codeMap.put(303, "See Other («смотреть другое»)");
            codeMap.put(304, "Not Modified («не изменялось»)");
            codeMap.put(305, "Use Proxy («использовать прокси»)");
            codeMap.put(306, "— зарезервировано (код использовался только в ранних спецификациях)");
            codeMap.put(307, "Temporary Redirect («временное перенаправление»)");
            codeMap.put(308, "Permanent Redirect («постоянное перенаправление»)");
            codeMap.put(400, "Bad Request («неправильный, некорректный запрос»)");
            codeMap.put(401, "Unauthorized («не авторизован (не представился)»)");
            codeMap.put(402, "Payment Required («необходима оплата»)");
            codeMap.put(403, "Forbidden («запрещено (не уполномочен)»)");
            codeMap.put(404, "Not Found («не найдено»)");
            codeMap.put(405, "Method Not Allowed («метод не поддерживается»)");
            codeMap.put(406, "Not Acceptable («неприемлемо»)");
            codeMap.put(407, "Proxy Authentication Required («необходима аутентификация прокси»)");
            codeMap.put(408, "Request Timeout («истекло время ожидания»)");
            codeMap.put(409, "Conflict («конфликт»)");
            codeMap.put(410, "Gone («удалён»)");
            codeMap.put(411, "Length Required («необходима длина»)");
            codeMap.put(412, "Precondition Failed («условие ложно»)");
            codeMap.put(413, "Payload Too Large («полезная нагрузка слишком велика»)");
            codeMap.put(414, "URI Too Long («URI слишком длинный»)");
            codeMap.put(415, "Unsupported Media Type («неподдерживаемый тип данных»)");
            codeMap.put(416, "Range Not Satisfiable («диапазон не достижим»)");
            codeMap.put(417, "Expectation Failed («ожидание не удалось»)");
            codeMap.put(418, "I’m a teapot («я — чайник»)");
            codeMap.put(419, "Authentication Timeout (not in RFC 2616) («обычно ошибка проверки CSRF»)");
            codeMap.put(421, "Misdirected Request");
            codeMap.put(422, "Unprocessable Entity («необрабатываемый экземпляр»)");
            codeMap.put(423, "Locked («заблокировано»)");
            codeMap.put(424, "Failed Dependency («невыполненная зависимость»)");
            codeMap.put(425, "Too Early («слишком рано»)");
            codeMap.put(426, "Upgrade Required («необходимо обновление»)");
            codeMap.put(428, "Precondition Required («необходимо предусловие»)");
            codeMap.put(429, "Too Many Requests («слишком много запросов»)");
            codeMap.put(431, "Request Header Fields Too Large («поля заголовка запроса слишком большие»)");
            codeMap.put(449, "Retry With («повторить с»)");
            codeMap.put(451, "Unavailable For Legal Reasons («недоступно по юридическим причинам»)");
            codeMap.put(499, "Client Closed Request (клиент закрыл соединение)");
            codeMap.put(500, "Internal Server Error («внутренняя ошибка сервера»)");
            codeMap.put(501, "Not Implemented («не реализовано»)");
            codeMap.put(502, "Bad Gateway («плохой, ошибочный шлюз»)");
            codeMap.put(503, "Service Unavailable («сервис недоступен»)");
            codeMap.put(504, "Gateway Timeout («шлюз не отвечает»)");
            codeMap.put(505, "HTTP Version Not Supported («версия HTTP не поддерживается»)");
            codeMap.put(506, "Variant Also Negotiates («вариант тоже проводит согласование»)");
            codeMap.put(507, "Insufficient Storage («переполнение хранилища»)");
            codeMap.put(508, "Loop Detected («обнаружено бесконечное перенаправление»)");
            codeMap.put(509, "Bandwidth Limit Exceeded («исчерпана пропускная ширина канала»)");
            codeMap.put(510, "Not Extended («не расширено»)");
            codeMap.put(511, "Network Authentication Required («требуется сетевая аутентификация»)");
            codeMap.put(520, "Unknown Error («неизвестная ошибка»)");
            codeMap.put(521, "Web Server Is Down («веб-сервер не ра ботает»)");
            codeMap.put(522, "Connection Timed Out («соединение не отвечает»)");
            codeMap.put(523, "Origin Is Unreachable («источник недоступен»)");
            codeMap.put(524, "A Timeout Occurred («время ожидания истекло»)");
            codeMap.put(525, "SSL Handshake Failed («квитирование SSL не удалось»)");
            codeMap.put(526, "526 Invalid SSL Certificate («недействительный сертификат SSL»)[");
        }

        for (var item : sortedMap.entrySet()) {
            text += header.formatted(item.getKey().toString(), item.getValue().toString(), codeMap.get(item.getKey()));
        }
        text += "\n";
        return this;
    }

    public LogAnalysisStream requestedResources() {
        Map<String, Integer> map = new HashMap<>();

        for (var item : this.logs) {
            if (map.containsKey(item.request().resource())) {
                map.put(item.request().resource(), map.get(item.request().resource()) + 1);
            } else {
                map.put(item.request().resource(), 1);
            }
        }

        //Sort
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        map.clear();

        String header = "| %-20s | %10s |\n";
        text += "####### Запрашиваемые ресурсы\n" +
                header.formatted("Ресурс", "Количество")
                + "|:"+"-".repeat(20)+":|:" + "-".repeat(10) + ":|\n";
        for (var item : sortedMap.entrySet()) {
            text += header.formatted(item.getKey(), item.getValue().toString());
        }
        text += "\n";
        return this;
    }

    //Extra
    public LogAnalysisStream httpAgents(){
        Map<String, Integer> map = new HashMap<>();

        for (var item : this.logs) {
            String httpAgent = item.httpUserAgent();
            if(httpAgent.contains(" ")) {
                httpAgent = item.httpUserAgent().substring(0, item.httpUserAgent().indexOf(" "));
            }

            if (map.containsKey(httpAgent)){
                map.put(httpAgent, map.get(httpAgent) + 1);
            } else {
                map.put(httpAgent, 1);
            }}


        //Sort
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(15)
            .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        map.clear();

        String header = "| %-23s | %10s |\n";
        text += "####### Http Агенты\n" +
                header.formatted("Название", "Количество")
                + "|:"+"-".repeat(23)+":|:" + "-".repeat(10) + ":|\n";
        for (var item : sortedMap.entrySet()) {
            text += header.formatted(item.getKey(), item.getValue().toString());
        }
        text += "\n";
        return this;
    }

    public LogAnalysisStream highLoad(){
        Map<String, Integer> map = new HashMap<>();

        for (var item : this.logs) {
            String address = item.address();

            if (map.containsKey(address)){
                map.put(address, map.get(address) + 1);
            } else {
                map.put(address, 1);
            }}

        //Sort
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(15)
            .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        map.clear();

        String header = "| %-23s | %10s |\n";
        text += "####### Активные пользователи\n" +
                header.formatted("Название", "Количество")
                + "|:"+"-".repeat(23)+":|:" + "-".repeat(10) + ":|\n";

        for (var item : sortedMap.entrySet()) {
            text += header.formatted(item.getKey(), item.getValue().toString());
        }
        text += "\n";
        return this;
    }
}
