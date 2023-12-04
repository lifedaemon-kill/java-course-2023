package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    private Main() {
    }

    public static void streamChain() {
        Path filePath = Path.of("src/test/java/edu/hw6/Task4/Files/output.txt");

        try (OutputStream fileOutputStream = Files.newOutputStream(filePath, StandardOpenOption.CREATE);
             OutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter writer = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             PrintWriter printWriter = new PrintWriter(writer)) {

            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");

            log.info("Запись в файл успешно выполнена.");

        } catch (IOException e) {
            log.info("Произошла ошибка при записи в файл: " + e.getMessage());
        }
    }
}
