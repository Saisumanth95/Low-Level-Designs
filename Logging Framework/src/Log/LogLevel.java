package Log;

public enum LogLevel {
    DEBUG(1), WARN(2), ERROR(3), INFO(4);

    private final int level;
    LogLevel(int level) { this.level = level; }
    public int getLevel() { return level; }

}
