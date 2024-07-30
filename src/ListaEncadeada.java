public class ListaEncadeada<T> {
    private Celula<T> primeira;
    private Celula<T> ultima;
    private int totalElementos = 0;

    public void adicionarInicio(T elemento) {
        Celula<T> nova = new Celula<T>(elemento, this.primeira);
        this.primeira = nova;

        if(this.totalElementos == 0) {
            this.ultima = nova;
        }

        this.totalElementos++;
    }

    public void adicionarFinal(T elemento) {
        Celula<T> nova = new Celula<T>(elemento);
        this.ultima.setProxima(nova);
        this.ultima = nova;

        if (this.totalElementos == 0) {
            this.primeira = nova;
        }

        this.totalElementos++;
    }

    public void adicionarPosicao(T elemento, int posicao) {
        Celula<T> nova = new Celula<T>(elemento);
        Celula<T> aux = this.primeira;

        for(int i = 0; i <= posicao; i++) {

        }
    }

    public void imprimir() {
        Celula<T> aux = this.primeira;

        System.out.print("[");
        for (int i = 0; i < this.totalElementos - 1; i++) {
            System.out.print(aux.getElemento() + ", ");
            aux = aux.getProxima();
        }
        System.out.println(aux.getElemento() + "]");
    }

    public int size() {
        return this.totalElementos;
    }
}