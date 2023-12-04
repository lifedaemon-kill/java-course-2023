package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter other) {
        return path -> this.accept(path) && other.accept(path);
    }

    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    //Атрибут readable
    static AbstractFilter readable() {
        return Files::isReadable;
    }

    //Атрибут writable
    static AbstractFilter writable() {
        return Files::isWritable;
    }

    //Размер файла
    static AbstractFilter largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    //Расширение файла
    static AbstractFilter globMatches(String extension) {
        return path -> path.getFileName().toString().endsWith(extension);
    }

    //Имя файла с помощью регулярных выражений
    static AbstractFilter regexContains(String regex) {

        return path -> path.getFileName().toString().matches(regex);
    }

    //магические начальные идентификаторы
    static AbstractFilter magicNumber(int number, char... magicBytes) {
        return path -> {
            byte[] fileHeader = Files.readAllBytes(path);

            int countOfMagicNumbers = 4;

            if (fileHeader.length >= countOfMagicNumbers) {
                return fileHeader[0] == (byte) number
                       && fileHeader[1] == (byte) magicBytes[0]
                       && fileHeader[2] == (byte) magicBytes[1]
                       && fileHeader[countOfMagicNumbers - 1] == (byte) magicBytes[2];
            } else {
                return false;
            }
        };
    }
}
