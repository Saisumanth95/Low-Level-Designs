package States;

public class IdleState implements State{
    @Override
    public void handleRequest() {
        System.out.println("Welcome to Sai's Instant Vending Machine\n");
    }
}
