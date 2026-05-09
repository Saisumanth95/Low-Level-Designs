package Log;

public class SimpleFormatter implements LogFormatter {
    @Override
    public String format(LogMessage logMessage) {
        StringBuilder output = new StringBuilder();

        output.append(logMessage.getLocalDateTime().toLocalTime()).append(" ")
                .append(logMessage.getLogLevel())
                .append(" ")
                .append("Thread : ")
                .append(logMessage.getThreadName())
                .append(" :: ")
                .append(logMessage.getMessage());

        return output.toString();
    }
}
