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

         while (valor) {

            /* Condicional para caso o play seja ativado */
            if (play) {
                if (!rec.qIsEmpty()) {
                    opcao = rec.dequeue();
                } else {
                    System.out.println("Reprodução finalizada...");
                    play = false;
                    continue;
                }
            }

            // Após o play finalizar, o programa espera para o usuário digitar novamente
            else {
                String user = scanner.nextLine();
                // Deixa tudo em letra Maiúscula
                user = user.toUpperCase();
                opcao = user;
                // Remove todos os espaços
                opcao = opcao.replaceAll("\\s", "");
            }

            // Opção VARS
            if (opcao.equals("VARS")){

                // Se a lista de variáveis estiver vazia imprime que não foi definida nenhuma variável
                if (vars.arrayEmpty()) {
                    System.out.println("Nenhuma variável definida.");
                    continue;
                }

                else {
                    // Usa loop for e vai imprimindo cada variável com seu respectivo valor até o momento que ele
                    // encontrar um null
                    for (int i = 0; i < 15; i++) {
                        if (vars.seeElement(i) != null) {
                            System.out.println(vars.seeElement(i) + " = " + valores.seeElement(i));
                        };
                    }
                    continue;
                }

            }


            //Opcao de RESET
            else if (opcao.equals("RESET")) {

                // Loop para remover todos os elementos
                for (int i = 0; i < 10; i++) {
                    vars.removeElement(i);
                    valores.removeElement(i);
                }

                // Reinicia as posições dos objetos vars e valores
                vars.setPosicao(0);
                valores.setPosicao(0);
                System.out.println("Variáveis reiniciadas.");
                continue;
            }

            // Opção REC
            else if (opcao.equals("REC")){

                // Verifica se o rec está vazio
                if (rec.qIsEmpty()) {
                    System.out.println("Iniciando gravação... (REC: 0/10)");
                }
                // Caso não esteja, continua a gravação
                else {
                    System.out.println("Continuando gravação... (REC: " + count + "/10)");
                }
                boolean recLoop = true;

                while (recLoop) {
                    if (count != 10) {
                         // Inicia o Scanner
                        Scanner REC = new Scanner(System.in);

                        // Armazena a string em word
                        String word = REC.nextLine();

                        // Transforma a string para maiusculo
                        word = word.toUpperCase();

                        // Armazena em element a string word
                        String element = word;

                        // Retira todos os espaçoes de element
                        element = element.replaceAll("\\s", "");

                        // Para a gravação
                        if (element.equals("STOP")) {
                            System.out.println("Encerrando gravação... (REC: " + count + "/10)");
                            break;
                        }

                        // Caso não seja STOP, verifica se é um dos comandos proibidos
                        else if (element.equals("PLAY") || element.equals("ERASE") || element.equals("REC")  ) {
                            System.out.println("Erro: comando inválido para gravação");
                        }

                        // Se passar pelas condicionais, apenas adiciona no array e aumenta o contador
                        else {
                            count++;
                            System.out.println("(REC: " + count + "/10) " + word);
                            rec.enqueue(element);
                        }
                    }

                    // Se o rec estiver cheio, ele para a gravação
                    else {
                        System.out.println("REC CHEIO");
                        System.out.println("Encerrando gravação");
                        break;
                    }
                } continue;
            }

        // remover
        System.out.println("REMOVER");

       

        
    }
 }
            // Opção STOP (como não está dentro do rec, imprime que não tem gravação)
            else if (opcao.equals("STOP")){
                System.out.println("Não há gravação para ser encerrada");
            }

            // Opção PLAY
            else if (opcao.equals("PLAY")){

                // Se rec estiver com algum elemento, começa a reprodução colocando o valor play em true
                if (!rec.qIsEmpty()) {
                    System.out.println("Reproduzindo gravação...");
                    play = true;
                }

                // Caso contrário, imprime que não há gravação para ser reproduzida
                else {
                    System.out.println("Não há gravação para ser reproduzida");
                }
                continue;
            }


            // Opção ERASE
            else if (opcao.equals("ERASE")){

                // Enquanto a fila rec estiver vazia, elimina os elementos
                while (!rec.qIsEmpty()) {
                    rec.dequeue();
                }

                // Reinicia a primeira e ultima posição do objeto rec
                rec.setPriposicao(0);
                rec.setUltposicao(0);
                System.out.println("Gravação apagada.");
                count = 0; // Reinicia o contador
                continue;
            }


            //Opcao de EXIT
            else if (opcao.equals("EXIT")){
                System.out.println("Programa Encerrado");
                break;
            }