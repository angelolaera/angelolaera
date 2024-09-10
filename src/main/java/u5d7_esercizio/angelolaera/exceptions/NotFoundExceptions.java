package u5d7_esercizio.angelolaera.exceptions;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(int id) {
            super("Elemento con ID " + id + " non trovato");
        }
}
