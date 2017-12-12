package br.edu.ufcg.jukeboxdozenanzin.validation.error;

public class JukeboxException extends RuntimeException {

    public JukeboxException() {
        super();
    }
    public JukeboxException(String message, Throwable cause) {
        super(message, cause);
    }
    public JukeboxException(String message) {
        super(message);
    }

    public JukeboxException(Throwable cause) {
        super(cause);
    }
}
