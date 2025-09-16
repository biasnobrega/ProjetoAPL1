/* Beatriz Silva Nóbrega - 10435789
 * Eduardo Kenji Hernandes Ikematu - 10439924
 * Matheus Guion - 10437693
 */

 import java.util.Scanner;
 import commands.vars.*;

 public class Main{
    public static void main(String[] args) {

        //criamos 2 listas e 1 fila para armanezar valores , variáveis e o REC 
        Array<Integer> valores = new Array<>();
        Array<Character> variaveis = new Array<>();
        Fila<String> rec = new Fila<>();

        //criamos uma pilhas para armanezar as expressões matemáticas infixas
        Pilha<Character> pilha = new Pilha<>();

        //pilha para cálculo das expressões posfixas
        Pilha<Integer> pilhaPosfixa = new Pila<>();

        //string saída que armazena a expressão posfixa
        String saida = "";

        Scanner scanner = new Scanner(System.in);

        //manter o loop ativo
        boolean valor = true;

        //verifica se deve rodar o PLAY
        boolean play = false;

        //inicia a opção
        String opcao = "";

        //diz se a expressão infixa está invalida ou não
        boolean infixaErro = false;

        //calcula a expressão posfixa
        boolean posFixa = false;

        //verifica se entra na infixa
        boolean INFIXA = false;

        //contador do REC
        int count = 0;



        
    }
 }