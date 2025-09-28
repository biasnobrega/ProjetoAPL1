/* Beatriz Silva Nóbrega - 10435789
 * Eduardo Kenji Hernandes Ikematu - 10439924
 * Matheus Guion - 10437693
 * 
 * Referencias Utilizadas:
Como ver se um caractere é um numero
    https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a-character-is-a-letter-or-number-in-java-withou
Como transformar caractere em inteiro, mostrando o valor numerico e não em ASCII
https://www.scaler.com/topics/char-to-int-in-java/
 
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

             // Ver valor de UMA variável
            else if (opcao.length() == 1 && Character.isLetter(opcao.charAt(0))) {
                if (vars.searchElement(opcao.charAt(0))) {
                    int pos = vars.elementPosition(opcao.charAt(0));
                    System.out.println(valores.seeElement(pos));
                } else {
                    System.out.println("Variável não definida");
                } continue;
            }


            //Opcao VAR = VALUE
            else if (opcao.charAt(0) >= 'A' && opcao.charAt(0) <= 'Z') {

                // Caso o segundo caractere seja " = "
                if (opcao.charAt(1) == '=') {

                    // Verifica se o 2 caractere é um numero
                    if (Character.isDigit(opcao.charAt(2))) {

                        // Inicia uma string numero (possibilita armazenar numeros maiores que 9)
                        String numero = "";

                        // Adiciona na string o numero que estiver na posição 2 da opcao
                        numero += opcao.charAt(2);

                        // Adiciona o resto dos numeros dentro da string
                        for (int j = 3; j < opcao.length(); j++) {
                            numero += opcao.charAt(j);
                        }

                        // Percorre a lista vars para ver se o caractere já existe
                        if (vars.searchElement(opcao.charAt(0))) {

                            // Caso encontre a variável, guarda sua posição
                            int pos = vars.elementPosition(opcao.charAt(0));

                            // Pega o valor numérico da string
                            valores.changeElement(pos, Integer.parseInt(numero));

                            // Imprime o que o usuário digitou
                            System.out.println(opcao);

                            continue;

                        } else {

                            // Caso não encontre a variável já definida na lista
                            // Adiciona a variável na lista
                            vars.addElement(opcao.charAt(0));

                            // Adiciona o valor numérico na lista dos números
                            valores.addElement(Integer.parseInt(numero));

                            // Imprime o que o usuário digitou
                            System.out.println(opcao);
                            continue;
                        }

                    } else { System.out.print("Erro comando inválido"); }
                }
            }

             // Verifica se a opcao se trata de uma expressão infixa, procurando por operadores
            for (int i = 0; i < opcao.length(); i++) {

                // Caso encontre algum, declara INFIXA como true
                if (opcao.charAt(i) == '+' || opcao.charAt(i) == '-' || opcao.charAt(i) == '/' || opcao.charAt(i) == '*' || opcao.charAt(i) == '^' || opcao.charAt(i) == '(' || opcao.charAt(i) == ')') {
                    INFIXA = true;
                }

                // Se encontrar algum elemento que não seja algum dos operadores
                else if (!Character.isLetterOrDigit(opcao.charAt(i))) {

                    // Verifica se está no play
                    if (play) {
                        System.out.println(opcao);
                    }

                    // Imprime operador invalido
                    System.out.println("Erro: operador inválido");
                    operadorInvalido = true;
                    INFIXA=true;
                    break;}
            }

            if (INFIXA) {

                // Se tiver um operador invalido não permite calcular a expressão
                if (operadorInvalido) {
                    operadorInvalido = false;
                    continue;
                }

                // Caso esteja em play imprime a expressão
                if (play) {
                    System.out.println(opcao);
                }

                // Contadores para verificar ( )
                int contadorAbre = 0, contadorFecha = 0;

                // Conta quantas ( e ) existem e caso seja um valor diferente não permite ser calculado
                for (int i = 0; i < opcao.length(); i++) {
                    if (opcao.charAt(i) == '(') {
                        contadorAbre += 1;
                    }
                    else if (opcao.charAt(i) == ')') {
                        contadorFecha += 1;
                    }
                }
                if (contadorAbre != contadorFecha) {
                    System.out.println("Erro: expressão inválida");
                    INFIXA = false;
                    continue;
                }

                //Opcao expressao matematica infixa transformando para posfixa
                for (int i = 0; i <= opcao.length(); i++) {

                    char simbolo = opcao.charAt(i);

                    // Verifica se já está no final da opcao
                    if (i == (opcao.length() - 1) ) {

                        // Se tiver verifica se o caractere atual é uma letra e adiciona ele
                        if (Character.isLetter(simbolo)) {
                            saida += simbolo;
                        }

                        if (simbolo == ')') {
                            try {
                                while (!pilha.isEmpty() && pilha.topo() != '(') {
                                    saida += pilha.pop();
                                }
                                pilha.pop();
                            } catch (Exception ignored) { }
                        }

                        // Esvazia toda a pilha
                        while(!pilha.isEmpty()) {
                            try {
                                saida += pilha.pop();
                            } catch (Exception ignored) { }
                        }

                        // Se deu erro na expressão infixa, a expressão não vai para o calculo e a saida reinicia
                        if (infixaErro) {
                            saida = "";
                            posFixa = false;
                            break;
                        }
                        // Caso não de erro, a expressão será direcionada para o calculo
                        else {
                            posFixa = true;
                            break;
                        }
                    }

                    //Verifica se a expressao esta correta; ex: x - TESTE
                    else if (Character.isLetter(simbolo)) {
                        if (i + 1 < opcao.length() && Character.isLetter(opcao.charAt(i + 1))) {
                            System.out.println("Erro: expressão inválida.");
                            posFixa = false;
                            saida = "";
                            while (!pilha.isEmpty()) {
                                try {
                                    pilha.pop();
                                } catch (Exception ignored) {}
                            }
                            break;
                        } else {
                            saida += simbolo;
                        }
                    }

                    //Verifica se tem numeros na expressao infixa
                    else if (Character.isDigit(simbolo)) {
                        System.out.println("Erro: não deve ter números na expressão infixa");
                        infixaErro = true;
                        break;
                    }

                    //Verifica se é um (, se for coloca na pilha
                    else if (simbolo == '(') {
                        try {
                            pilha.push(simbolo);
                        } catch (Exception ignored) { }
                    }

                    //Verifica se é um (, se fore ele coloca na saida tudo ate o ) e depois o tira da pilha
                    else if (simbolo == ')') {
                        try {
                            while (!pilha.isEmpty() && pilha.topo() != '(') {
                                saida += pilha.pop();
                            }
                            pilha.pop();


                        } catch (Exception ignored) { }
                    }

                    //Se a pilha estiver vazia coloca o primeiro operador
                    else if (pilha.isEmpty()) {
                        try {
                            pilha.push(simbolo);
                        } catch (Exception ignored) { }
                    }

                    //Verifica se o simbolo é + ou -
                    else if (simbolo == '+' || simbolo == '-') {
                        try {

                            // Verifica se o topo da pilha contém um parêntese aberto '(' ou fechado ')'
                            if (pilha.topo() == '(' || pilha.topo() == ')') {
                                // Se for o caso, simplesmente empilha o operador atual
                                pilha.push(simbolo);

                            } else {
                                // Caso contrário, desempilha o topo e adiciona à saída antes de empilhar o novo operador
                                saida += pilha.pop();
                                pilha.push(simbolo);
                            }
                        } catch (Exception ignored) { }
                    }

                    // Se o símbolo for '*' ou '/'
                    else if (simbolo == '*' || simbolo == '/') {
                        try {
                            // Se o topo da pilha não for '*', '/' ou '^', desempilha o operador para a saída
                            if (pilha.topo() != '*' || pilha.topo() != '/' || pilha.topo() != '^') {
                                saida += pilha.pop();
                                pilha.push(simbolo);

                            } else {
                                // Caso contrário, apenas empilha o operador
                                pilha.push(simbolo);

                            }
                        } catch (Exception ignored) { }  // Captura exceções, mas as ignora
                    }

                    // Se o símbolo for '^' (exponenciação)
                    else if (simbolo == '^') {
                        try {
                            // Se o topo da pilha não for '^', empilha o operador
                            if (pilha.topo() != '^') {
                                pilha.push(simbolo);
                            } else {
                                // Caso contrário, desempilha o operador e depois empilha o novo
                                saida += pilha.pop();
                                pilha.push(simbolo);
                            }
                        } catch (Exception ignored) { }
                    }
                }

                // Caso tenha dado erro na expressão infixa, se mostra a mensagem de erro
                if (infixaErro) {
                    System.out.println("Erro na expressão infixa!");
                    infixaErro = false;
                    continue;
                }


                // CÁLCULO DAS EXPRESSÕES POSFIXAS
                if (posFixa) {

                    // Booleano utilizado para validar se alguma variável não está definida e não mostrar o resultado
                    boolean erroVar = false;

                    // Resultado vai armazenar a operação entre o valor 1 e o valor 2
                    int resultado = 0, valor1, valor2;

                    // Vai percorrer cada caractere da saida adquirida na expressão posfixa
                    for (int i = 0; i < saida.length(); i++){

                        // Armazena o caractere atual na variável caractere
                        char caractere = saida.charAt(i);

                        // Verifica se o caractere da saida é uma letra
                        if (Character.isLetter(caractere)) {
                            // Verifica se o caractere existe na lista
                            if (vars.searchElement(caractere)) {
                                try {
                                    // Se existir, adiciona seu valor na pilha
                                    int pos = vars.elementPosition(caractere);
                                    pilhaPosfixa.push(valores.seeElement(pos));

                                } catch (Exception ignored)  {}
                            }

                            // Se não existir imprime que a variável não foi definida
                            else {
                                erroVar = true;
                                System.out.println("Erro: variável " + caractere + " não definida");
                            }
                        }

                        // Verifica se o caractere é +
                        else if (caractere == '+') {
                            try {

                                valor1 = pilhaPosfixa.pop();

                                valor2 = pilhaPosfixa.pop();

                                resultado = valor1 + valor2;

                                pilhaPosfixa.push(resultado);
                            } catch (Exception ignored) {}
                        }

                        // Verifica se o caractere é -
                        else if (caractere == '-') {
                            try {

                                valor1 = pilhaPosfixa.pop();

                                valor2 = pilhaPosfixa.pop();

                                resultado = valor2 - valor1;

                                pilhaPosfixa.push(resultado);
                            } catch (Exception ignored) {}
                        }

                        // Verifica se o caractere é *
                        else if (caractere == '*') {
                            try {

                                valor1 = pilhaPosfixa.pop();

                                valor2 = pilhaPosfixa.pop();

                                resultado = valor1 * valor2;

                                pilhaPosfixa.push(resultado);
                            } catch (Exception ignored) {}
                        }

                        // Verifica se o caractere é /
                        else if (caractere == '/') {
                            try {

                                valor1 = pilhaPosfixa.pop();

                                valor2 = pilhaPosfixa.pop();

                                if  (valor1 == 0) {
                                    System.out.println("Não pode fazer divisões por zero!");
                                    saida = "";
                                    break;
                                } else {
                                    resultado = valor2 / valor1;

                                    pilhaPosfixa.push(resultado);
                                }
                            } catch (Exception ignored) {}
                        }

                        // Verifica se o caractere é ^
                        else if (caractere == '^') {
                            try {

                                valor1 = pilhaPosfixa.pop();

                                valor2 = pilhaPosfixa.pop();

                                resultado = 1;
                                for (int j = 1; j <= valor1; j++) {
                                    resultado *= valor2;
                                }
                                pilhaPosfixa.push(resultado);
                            } catch (Exception ignored) {}
                        }



                        // Ao percorrer toda a saida e não tiver mais que operar nada, se imprime o resultado
                        if (i == saida.length() - 1) {

                            // Se tiver alguma variável não definida apenas não imprime o resultado e sai do loop
                            if (erroVar) {
                                saida = "";
                                break;
                            }

                            // Caso contrário, imprime o resultado e sai do loop
                            else {
                                System.out.println(resultado);
                                saida = "";
                                break;
                            }
                        }

                    }
                }
                INFIXA = false;
            }
            else {System.out.println("Erro: comando inválido");}

        }
        scanner.close();
    }
}

