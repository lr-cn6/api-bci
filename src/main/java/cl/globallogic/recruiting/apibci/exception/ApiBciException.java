package cl.globallogic.recruiting.apibci.exception;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.y.z - 03-12-2019
 * @since 1.y.z - 03-12-2019
 */
public class ApiBciException extends Exception {

    private final String mensaje;

    public ApiBciException(String mensaje) {
        this.mensaje = mensaje;
    }

    public ApiBciException(Throwable t) {
        this.mensaje = t.getMessage();
    }

    public String getMensaje() {
        return mensaje;
    }
}
