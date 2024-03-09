package evrentan.qrcodegenerator.qrcodegeneratorbackend.exception;

public class QrCodeTextValidationException extends RuntimeException {

    private final String message;

    public QrCodeTextValidationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
