public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();

        lista.adicionarInicio(1);
        lista.adicionarInicio(2);
        lista.adicionarInicio(3);

        lista.adicionarFinal(4);
        lista.adicionarFinal(5);

        lista.adicionarPosicao(6, 1);

        lista.imprimir();
        System.out.println("Quantidade de elementos da lista: " + lista.size());

        lista.excluirFinal();

        lista.imprimir();
        System.out.println("Quantidade de elementos da lista: " + lista.size());
    }
}
