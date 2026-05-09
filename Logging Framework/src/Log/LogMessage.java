package Log;

import java.time.LocalDateTime;

public class LogMessage {
    private String message;
    private LogLevel level;
    private LocalDateTime localDateTime;
    private String threadName;

    public LogMessage(String message, LogLevel level, LocalDateTime localDateTime, String threadName) {
        this.message = message;
        this.level = level;
        this.localDateTime = localDateTime;
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public LogLevel getLogLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
