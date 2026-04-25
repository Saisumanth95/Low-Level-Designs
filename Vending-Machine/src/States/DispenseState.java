package States;

public class DispenseState implements State{
    @Override
    public void handleRequest() {
        System.out.println("************************ Product Dispensed ********************************");
        try {
            Thread.sleep(Long.parseLong("10000"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
