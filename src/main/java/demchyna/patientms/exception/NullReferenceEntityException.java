package demchyna.patientms.exception;

public class NullReferenceEntityException extends RuntimeException {
    public NullReferenceEntityException() {    }

    public NullReferenceEntityException(String message) {
        super(message);
    }
}
