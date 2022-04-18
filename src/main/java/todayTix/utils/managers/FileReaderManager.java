package todayTix.utils.managers;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderManager {

    @SneakyThrows
    public String getHtmlReport(String path) {
        return Files.readString(Path.of(path));
    }

}