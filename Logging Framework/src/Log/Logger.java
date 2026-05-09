package Log;

import Appender.LogAppender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger logger = null;
    private List<LogAppender> appenders;
    public static Logger getInstance(){
        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                }
            }
        }
        return logger;
    }
    private Logger(){
        this.appenders = new ArrayList<>();
    }

    public void addAppender(LogAppender appender){
        this.appenders.add(appender);
    }

    public void info(String message){
        LogMessage logMessage = new LogMessage(message, LogLevel.INFO, LocalDateTime.now(), Thread.currentThread().getName());
        notifyAppenders(logMessage);
    }

    public void error(String message){
        LogMessage logMessage = new LogMessage(message, LogLevel.ERROR, LocalDateTime.now(), Thread.currentThread().getName());
        notifyAppenders(logMessage);
    }

    public void debug(String message){
        LogMessage logMessage = new LogMessage(message, LogLevel.DEBUG, LocalDateTime.now(), Thread.currentThread().getName());
        notifyAppenders(logMessage);
    }

    private void notifyAppenders(LogMessage logMessage){
        for(LogAppender appender : this.appenders){
            appender.appendMessage(logMessage);
        }
    }

}
