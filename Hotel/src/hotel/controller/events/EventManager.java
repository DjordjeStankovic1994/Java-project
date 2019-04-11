package hotel.controller.events;

/**
 * Holds every EventHandler instance
 *
 * @author vboskovic
 */
public class EventManager {

    private CancelEvent cancelEvent = null;
    private LoginEvent loginEvent = null;
    private AddNewUserEvent addNewUserEvent = null;
    private RemoveUserEvent removeUserEvent = null;
    private LogoutEvent logoutEvent = null;

    public EventManager() {
        cancelEvent = new CancelEvent();
        loginEvent = new LoginEvent();
        addNewUserEvent = new AddNewUserEvent();
        removeUserEvent = new RemoveUserEvent();
        logoutEvent = new LogoutEvent();
    }

    public CancelEvent getCancelEvent() {
        return cancelEvent;
    }

    public LoginEvent getLoginEvent() {
        return loginEvent;
    }

    public AddNewUserEvent getAddNewUserEvent() {
        return addNewUserEvent;
    }

    public RemoveUserEvent getRemoveUserEvent() {
        return removeUserEvent;
    }

    public LogoutEvent getLogoutEvent() {
        return logoutEvent;
    }

}
