package States;

public class IdleState implements State{
    @Override
    public void handleRequest() {
        System.out.println("\nWelcome to Sai's Instant Vending Machine");
        System.out.println("Press Y to continue : ");

    }
}
