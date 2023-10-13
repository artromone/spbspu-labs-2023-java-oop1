package exceptions;

import java.io.IOException;

public class InvalidFileFormatException extends IOException {
    public InvalidFileFormatException(String errorMessage){
        super(errorMessage);
    }
}
