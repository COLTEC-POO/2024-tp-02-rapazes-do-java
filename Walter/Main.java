import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int opcoes;
        do {
            System.out.println("=========================");
            System.out.println("MENU DE OPÇÕES BIBLIOTECA");
            System.out.println("Escolha uma opção (Digite 10 para sair)");
            System.out.println("1- Cadastrar livro");
            System.out.println("2- Cadastrar usuário");
            System.out.println("3- Pegar livro");
            System.out.println("4- Devolver livro");
            System.out.println("5-Ver livros disponíveis");
            Scanner ler = new Scanner(System.in);
            opcoes = ler.nextInt();
            Biblioteca biblioteca = new Biblioteca("Biblioteca ufmg");
            switch (opcoes) {
                case 1:
                    biblioteca.cadastrarLivro();
                    break;
                case 2:
                    biblioteca.cadastrarUsuario();
                    break;
                case 3:
                    biblioteca.realizarEmprestimo();
                    break;
                case 4:
                    biblioteca.realizarDevolucao();
                    break;
                case 5:
                    biblioteca.imprimirLivros();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(opcoes!=10);

    }
}
