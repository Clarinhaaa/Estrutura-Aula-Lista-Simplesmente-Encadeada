public class Celula<T> {
    private T elemento;
    private Celula<T> proxima;

    public Celula(T elemento, Celula<T> proxima) {
        this.elemento = elemento;
        this.proxima = proxima;
    }

    public Celula(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Celula<T> getProxima() {
        return proxima;
    }

    public void setProxima(Celula<T> proxima) {
        this.proxima = proxima;
    }

    @Override
    public String toString() {
        return "Celula [elemento=" + elemento + ", proxima=" + proxima + "]";
    }

}
