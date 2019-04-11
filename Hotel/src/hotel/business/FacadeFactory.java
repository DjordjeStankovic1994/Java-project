package hotel.business;

/**
 *
 * @author vboskovic
 */
public class FacadeFactory {

    private static Facade facade = new FacadeImpl();
    
    /**
     * @return Facade implementation
     */
    public static Facade getFacade() {
        return facade;
    }
    
}
