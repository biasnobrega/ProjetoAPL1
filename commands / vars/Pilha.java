/* 1° Beatriz Silva Nóbrega - 10435789
2° Eduardo Kenji Hernandes Ikematu - 10439924
3° Matheus Guion - 10437693
*/

package commands.vars;

public class Pilha <T> {

    private T pilha[];
    private int posicao;
    private int quantidade;

    public Pilha () {
        this.pilha = (T[]) new Object[15];
        this.posicao = 0;
        this.quantidade = 0;
    }

    public void seeElements() {
        System.out.print("[");
        for (int j = 0; j < pilha.length; j++) {
            if (j == ((pilha.length) - 1)) {
                System.out.print(pilha[j]);
            } else {
                System.out.print(pilha[j] + ", ");
            }
        }
        System.out.println("]");
    }

    public boolean isEmpty () {
        if (quantidade == 0) {
            return true;
        } return false;
    }

    public boolean isFull () {
        if (quantidade == pilha.length) {
            return true;
        } return false;
    }

    public T topo () throws Exception {
        if (!isEmpty()) {
            return pilha[posicao - 1];
        } throw new Exception("Pilha vazia!");
    }

    public void push (T element) throws Exception {
        if (!isFull()) {
            pilha[posicao] = element;
            posicao++;
            quantidade++;
        } throw new Exception("Pilha cheia!");
    }

    public T pop () throws Exception {
        if (!isEmpty()) {
            T aux;
            aux = pilha[posicao - 1];
            pilha[posicao - 1] = null;
            posicao--;
            quantidade--;
            return aux;
        } throw new Exception("Pilha vazia!");
    }



    public static void main (String[] args) {

    }
}