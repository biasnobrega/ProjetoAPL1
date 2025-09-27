<@453601756446851073> 
/* 1° Beatriz Silva Nobrega - 10435789
 * 2° Eduardo Kenji Hernandes Ikematu - 10439924
 * 3° Matheus Guion - 10437693
 */

package commands.vars;

public class Fila <T> {

    private T[] fila;
    private int ultPosicao;
    private int priPosicao;

    public Fila() {
        this.fila = (T[]) new Object[10];
        this.ultPosicao = 0;
        this.priPosicao = 0;
    }

    public boolean qIsFull() {
        if (this.ultPosicao == this.fila.length ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean qIsEmpty() {
        if (this.ultPosicao == this.priPosicao) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue (T element) {
        if (!qIsFull()) {
            fila[ultPosicao] = element;
            ultPosicao++;
        } else {
            System.out.print("Fila cheia!");
        }
    }

    public T dequeue () {
        T aux;
        aux = fila[priPosicao];
        fila[priPosicao] = null;
        priPosicao++;
        return aux;
    }

    public void setPriposicao (int number) {
        this.priPosicao = number;
    }

    public void setUltposicao (int number) {
        this.ultPosicao = number;
    }

    public T front () {
        return fila[priPosicao];
    }

    public T rear() {
        return fila[ultPosicao - 1];
    }

    public int size () {
        int count = 0;
        for (int i = 0; i < fila.length; i++) {
            if (fila[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int getPriPosicao () {
        return this.priPosicao;
    }

    public int getUltPosicao () {
        return this.ultPosicao;
    }

    public void printAllElements () {
        System.out.print("[");
        for (int j = 0; j < 10; j++) {
            System.out.print(fila[j] + ",");
        } System.out.println("]");
    }


    public static void main (String[] args) {

    }
}