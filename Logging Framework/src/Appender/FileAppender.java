package Appender;

import Log.LogFormatter;
import Log.LogMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileAppender implements LogAppender{

    private int minimumLogLevel;
    private LogFormatter logFormatter;
    private String filePath;

    public FileAppender(int minimumLogLevel, LogFormatter logFormatter, String filePath) {
        this.minimumLogLevel = minimumLogLevel;
        this.logFormatter = logFormatter;
        this.filePath = filePath;
    }

    @Override
    public void appendMessage(LogMessage logMessage) {

        if(logMessage.getLogLevel().getLevel() >= minimumLogLevel) {
            synchronized (this) {
                try {
                    String content = logFormatter.format(logMessage) + "\n";
                    Files.writeString(Path.of(filePath), content,  StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
