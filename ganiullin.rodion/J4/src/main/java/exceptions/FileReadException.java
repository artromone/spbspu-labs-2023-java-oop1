package exceptions;


import java.io.IOException;

public class FileReadException extends IOException {
    public FileReadException(String errorMessage) {
        super(errorMessage);
    }

}
