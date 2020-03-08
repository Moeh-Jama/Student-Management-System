package web.exception;

public class ModuleNotFoundException extends Exception {
    private long moduleId;

    public ModuleNotFoundException(long moduleId) {
        super(String.format("Module is not found with id : '%s'", moduleId));
    }
}
