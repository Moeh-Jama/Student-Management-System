package web.exception;

public class StudentNotFoundException extends Exception {
//    private long student_id;

    public StudentNotFoundException(long student_id) {
        super(String.format("No Student with id : '%s'", student_id));
    }
}
