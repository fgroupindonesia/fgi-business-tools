package frames;

/**
 *
 * @author staff
 */
public class Starter {
    
    static LoginFrame frame = new LoginFrame();
    
    public static void main(String[] args) {
        
        SplashScreenFrame spframe = new SplashScreenFrame();
        spframe.setVisible(true);
    }
    
    public static void continueLogging() {
        frame.setVisible(true);
    }
}
