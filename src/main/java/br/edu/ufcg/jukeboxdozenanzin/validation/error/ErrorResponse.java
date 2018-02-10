package br.edu.ufcg.jukeboxdozenanzin.validation.error;

public class ErrorResponse {

    private String message;
    private Integer errorCode;

    public ErrorResponse() {}

    public ErrorResponse(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
