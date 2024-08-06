public class ListaEncadeada<T> {
    private Celula<T> primeira;
    private Celula<T> ultima;
    private int totalElementos = 0;

    // * ADICIONAR

    public void adicionarInicio(T elemento) {
        Celula<T> nova = new Celula<T>(elemento, this.primeira);
        this.primeira = nova;

        if (this.totalElementos == 0) {
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
        if (!this.validarPosicao(posicao))
            throw new IllegalArgumentException("Posição inválida");

        if (posicao == 0) {
            this.adicionarInicio(elemento);
            return;
        }

        if (posicao == this.totalElementos - 1) {
            this.adicionarFinal(elemento);
            return;
        }

        Celula<T> aux = this.pesquisarCelula(posicao - 1);
        Celula<T> nova = new Celula<T>(elemento, aux.getProxima());

        aux.setProxima(nova);

        this.totalElementos++;
    }

    // * EXCLUIR

    public void excluirInicio() {
        Celula<T> aux = this.primeira;
        this.primeira = aux.getProxima();
        aux.setElemento(null);
        aux.setProxima(null);

        this.totalElementos--;
    }

    public void excluirFinal() {
        Celula<T> penultima = this.pesquisarCelula(this.totalElementos - 2);
        Celula<T> celulaParaExcluir = penultima.getProxima();
        this.ultima = penultima;
        celulaParaExcluir.setElemento(null);

        this.totalElementos--;
    }

    public void excluirPosicao(int posicao) {
        if (!this.validarPosicao(posicao))
            throw new IllegalArgumentException("Posição inválida");

        if (posicao == 0) {
            this.excluirInicio();
            return;
        }

        if (posicao == this.totalElementos - 1) {
            this.excluirFinal();
            return;
        }

        Celula<T> aux = this.pesquisarCelula(posicao - 1);
        Celula<T> celulaParaExcluir = aux.getProxima();

        aux.setProxima(this.pesquisarCelula(posicao + 1));

        celulaParaExcluir.setElemento(null);
        celulaParaExcluir.setProxima(null);

        this.totalElementos--;
    }

    // * OUTROS

    public Celula<T> pesquisarCelula(int posicao) {
        Celula<T> aux = this.primeira;

        for (int i = 0; i < posicao; i++) {
            aux = aux.getProxima();
        }

        return aux;
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

    private boolean validarPosicao(int posicao) {
        return (posicao >= 0 && posicao <= this.totalElementos - 1);
    }
}