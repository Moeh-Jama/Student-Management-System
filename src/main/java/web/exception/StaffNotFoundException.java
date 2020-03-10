package web.exception;

public class StaffNotFoundException extends Exception{
    public StaffNotFoundException(long staff_id) {
        super(String.format("No Staff with id : '%s'", staff_id));
    }
}
