package web.exception;

import web.model.Util.RegisteredUser;

public class RegisteredUserNotFoundException extends Exception {

    private long moduleId;

    public RegisteredUserNotFoundException(long person_id) {
        super(String.format("No Registered User with id : '%s'", person_id));
    }

}
