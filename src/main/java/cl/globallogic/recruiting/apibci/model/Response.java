package cl.globallogic.recruiting.apibci.model;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.y.z - 03-12-2019
 * @since 1.y.z - 03-12-2019
 */
public class Response {

    private String mensaje;

    public Response() {
    }

    public Response(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
