package hello;

/**
 * Created by Daniel on 3/26/16.
 */
public class FuckMessage {

    private static FuckMessage fuckMessage = new FuckMessage();

    private FuckMessage() {

    }

    public static FuckMessage createFuck() {
        return fuckMessage;
    }

    public void fuck() {
        System.out.println("what a fuck world");
    }
}
