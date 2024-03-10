import java.util.Scanner;

public class Main {
    static Scanner ler = new Scanner(System.in);
    static int respswitch;

    static int tamanho = 0;
    static boolean continuar = true;

    public static void main(String[] args) {
        Livro[] estante = new Livro[tamanho];

        System.out.println("==================================================");
        System.out.println("===BEM VINDO AO SIMULADOR DE ESTANTES DE LIVRO====");
        System.out.println("==SINTA-SE A VONTADE DE UTILIZAR NOSSOS RECURSOS==");
        System.out.println("==================================================");
        System.out.println("====ANTES DE COMEÇARMOS ======\n " +
                "INFORME O PRIMEIRO LIVRO QUE  IRÁ INSERIR NA SUA ESTANTE");

        do {

            System.out.println("O QUE DESEJA FAZER AGORA?");
            System.out.println("1 - INFORMAR UM NOVO LIVRO");
            System.out.println("2 - EXCLUIR UM LIVRO EXISTENTE");
            System.out.println("3 - VER LIVROS DA ESTANTE");
            System.out.println("4 - ORGANIZAR ESTANTE");

            respswitch = ler.nextInt();
            switch (respswitch){
                case 1 :
                    estante = createbooks(estante);
                    break;
                case 2:
                    estante = deletebooks(estante);
                    estante = trocadetamanho(estante);
                    break;
                case 3:
                    imprimir(estante);
                    break;
                case 4:
                    estante = organizador(estante);
                    break;
            }

            continuarcomand();
        } while (continuar);

    }

    public static Livro[] createbooks(Livro[] estante) {
        if(estante.length == 0){
            estante = aumentarcapacidade(estante);
        }
        System.out.println("QUAL É O TITULO DELE?=====");
        String titulo = ler.next();
        System.out.println("QUAL É A CATEGORIA DELE?====");
        String categoria = ler.next();
        System.out.println("QUANTAS PAGINAS ELE TEM?");
        int qtdPag = ler.nextInt();
        Livro livros = new Livro(titulo, categoria, qtdPag);
        if(tamanho == estante.length ){
            estante = aumentarcapacidade(estante);
        }
        for (int i = 0; i < estante.length; i++) {
            if (estante[i] == null) {
                estante[i] = livros;
                tamanho++;
                break;
            }
            }
        return estante;
    }

    public static Livro[] deletebooks(Livro[] estante){
        System.out.println("INFORME O LIVRO PARA SER EXCLUIDO");
        String titulo = ler.next();
        for(int i = 0; i < estante.length;i++){
            if(titulo.equalsIgnoreCase(estante[i].getTitulo())){
                estante[i] = null;
                tamanho--;
                break;
            }
            System.out.println("LIVRO EXTERMINADO");
        }
        return estante;
    }

    public static void continuarcomand(){
        System.out.println("DESEJA CONTINUAR UTILIZANDO MEU PROGRAMA ? S/N");
        String resposta = ler.next();
        if(resposta.equalsIgnoreCase("n")){
            continuar = false;
        }
    }
    public static Livro[] organizador(Livro[] estante) {
        int n = estante.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (estante[j].getTitulo().compareTo(estante[j + 1].getTitulo()) > 0) {
                    Livro temp = estante[j];
                    estante[j] = estante[j + 1];
                    estante[j + 1] = temp;
                }
            }
        }
        return estante;
    }


    public static Livro[] aumentarcapacidade(Livro[]estante) {
           Livro[] novo = new Livro[estante.length + 1];
            for (int i = 0; i < estante.length; i++) {
                novo[i] = estante[i];
        }
        return novo;
    }
    public static void imprimir(Livro[] estante){
        System.out.println("AQUI ESTÁ SUA ESTANTE");
        String[] help = new String[estante.length];
            for(int i = 0 ; i < estante.length; i++){
                help[i] = estante[i].mostrardados();
            }
            int i = 1;
        for(String item : help){
            System.out.print(i+" - ");
            System.out.println(item);
            System.out.println("--------------");
            i++;
        }
    }
    public static Livro[] trocadetamanho(Livro[]estante){
        Livro[]novo = new Livro[tamanho];
        for(int i = 0 ; i < novo.length; i++){
            novo[i] = estante[i];
        }
        return novo;
    }
    }

