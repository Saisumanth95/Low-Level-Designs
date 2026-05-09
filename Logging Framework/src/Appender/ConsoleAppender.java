package Appender;

import Log.LogFormatter;
import Log.LogMessage;

import java.util.Formatter;

public class ConsoleAppender implements LogAppender{

    private int minimumLogLevel;
    private LogFormatter logFormatter;

    public ConsoleAppender(int minimumLogLevel, LogFormatter formatter) {
        this.minimumLogLevel = minimumLogLevel;
        this.logFormatter = formatter;
    }

    @Override
    public void appendMessage(LogMessage logMessage) {

        if(logMessage.getLogLevel().getLevel() >= minimumLogLevel){
            synchronized (this) {
                System.out.println(logFormatter.format(logMessage));
            }
        }

    }
}
