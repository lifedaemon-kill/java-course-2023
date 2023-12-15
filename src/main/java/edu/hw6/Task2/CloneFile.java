package edu.hw6.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.log4j.Log4j2;

@Log4j2
class CloneFile {
    private CloneFile() {
    }

    public static void cloneFile(Path path) {
        String destinationFileName = findDestinationFileName(path);
        Path destinationPath = Paths.get(path.getParent() + "\\" + destinationFileName);

        try {
            Files.copy(path, destinationPath);
            log.info("File copied successfully to:" + destinationPath);
        } catch (IOException e) {
            log.error("Не удалось скопировать файл!" + "\n" + path + "\n" + destinationPath);
        }
    }

    public static String findDestinationFileName(Path path) {
        File sourceFile = new File(String.valueOf(path));

        String baseName = sourceFile.getName().replaceFirst("[.][^.]+$", "");
        String extension = sourceFile.getName().substring(sourceFile.getName().lastIndexOf("."));
        String dir = path.getParent() + "\\";

        int count = 1;
        String destinationFileName = baseName + " — копия" + extension;

        while (new File(dir + destinationFileName).exists()) {
            count++;
            destinationFileName = baseName + " — копия (" + count + ")" + extension;
        }

        return destinationFileName;
    }
}
