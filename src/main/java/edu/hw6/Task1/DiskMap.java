package edu.hw6.Task1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

@Log4j2
public class DiskMap {
    private DiskMap() {
    }

    public static String[] getValidLine(String line) throws Exception {
        String[] result = line.split(":");
        if (result.length != 2 || result[0].isEmpty() || result[1].isEmpty()) {
            throw new Exception("Line is broken!\nEvery line have to follow pattern string1:string2\\n");
        } else {
            return result;
        }
    }

    public static List<String> getValidStringArray(Map<String, String> map) throws Exception {
        List<String> res = new ArrayList<>();

        for (var key : map.keySet()) {
            String line = key + ":" + map.get(key);

            try {
                getValidLine(line);
            } catch (Exception e) {
                throw new Exception(e);
            }
            res.add(line);
        }

        return res;
    }

    public static Map<String, String> getFromFile(String strPath) throws Exception {
        try {
            Path path = Path.of(strPath);
            Map<String, String> data = new HashMap<>();

            var reader = Files.newBufferedReader(path);

            while (reader.ready()) {
                String line = reader.readLine();
                String[] splitLine = getValidLine(line);
                data.put(splitLine[0], splitLine[1]);
            }

            return data;
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception(e);
        }
    }

    public static void safeToFile(Map<String, String> data, String strPath) throws Exception {
        try {
            Path path = Path.of(strPath);
            var out = Files.newOutputStream(path, CREATE, WRITE);
            List<String> text = getValidStringArray(data);

            for (var line : text) {
                out.write(line.getBytes());
            }

        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception(e);
        }
    }
}
