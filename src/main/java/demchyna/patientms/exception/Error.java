package demchyna.patientms.exception;

import lombok.Data;

@Data
public class Error {
    private int status;
    private String url;
    private String message;

    public Error(int status, String url, String message) {
        this.status = status;
        this.url = url;
        this.message = message;
    }
}
