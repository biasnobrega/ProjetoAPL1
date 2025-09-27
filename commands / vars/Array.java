/* 1° Beatriz Silva Nóbrega - 10435789
 * 2° Eduardo Kenji Hernandes Ikematu - 10439924
 * 3° Matheus Guion - 10437693
 */

package commands.vars;

public class Array <T> {

    private T array[];
    private int posicao = 0;

    public Array(int tamanho) {
        this.array = (T[]) new Object[tamanho];
        this.posicao = 0;
    }

    public Array() {
        this.array = (T[]) new Object[15];
        this.posicao = 0;
    }

    public T seeElement (int indice) {
        return array[indice];
    }

    public void changeElement (int indice, T element) {
        this.array[indice] = element;
    }

    public void substituteElement(T element, int pos) {
        if (!arrayFull()) {
            this.array[pos] = element;
        }
    }

    public void setPosicao (int number) {
        this.posicao = number;
    }

    public void addElement(T element) {
        if (!arrayFull()) {
            this.array[posicao] = element;
            posicao++;
        }
    }

    public void removeElement(int indice) {
        if (!arrayFull()) {
            this.array[indice] = null;
            posicao--;
        }
    }

    public boolean searchElement (T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
        } return false;
    }

    public int elementPosition (T element) {
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                pos = i;
                break;
            }
        } return pos;
    }

    public void seeElements() {
        System.out.print("[");
        for (int j = 0; j < array.length; j++) {
            if (j == ((array.length) - 1)) {
                System.out.print(array[j]);
            } else {
                System.out.print(array[j] + ", ");
            }
        }
        System.out.println("]");
    }

    public boolean arrayEmpty() {
        if (this.seeElement(0) == null) {
            return true;
        }
        return false;
    }

    public boolean arrayFull () {
        if (posicao == this.array.length) {
            return true;
        }
        return false;
    }


    public static void main () {
    }

}
