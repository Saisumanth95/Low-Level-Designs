import Appender.ConsoleAppender;
import Appender.FileAppender;
import Log.LogFormatter;
import Log.LogMessage;
import Log.Logger;
import Log.SimpleFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Logger logger = Logger.getInstance();
    logger.addAppender(new ConsoleAppender(1, new SimpleFormatter()));
    logger.addAppender(new FileAppender(2, new SimpleFormatter(), "LogFile.txt"));

    logger.info("New User : Sai Sumanth created!!");
    logger.debug("The count is 5");
    logger.error("User login failed...");

}
