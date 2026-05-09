package Appender;

import Log.LogMessage;

public interface LogAppender {
    void appendMessage(LogMessage logMessage);
}
