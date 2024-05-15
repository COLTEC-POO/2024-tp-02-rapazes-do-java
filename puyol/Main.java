import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca dos Rapazes");

        // Exemplo de cadastro de livro
        Livro livro1 = new Livro("Apenas Pimbada", "Mago Dava Jonas", 2015, "Editora gameplayRJ");
        biblioteca.cadastrarLivro(livro1);

        Livro livro2 = new Livro("A Arte do Sexo", "Pudjol", 2024, "Editora Dos Rapazes");
        biblioteca.cadastrarLivro(livro2);

        Livro livro3 = new Livro("Sexologia", "Peter", 2023, "Editora Dos Rapazes");
        biblioteca.cadastrarLivro(livro3);

        Livro livro4 = new Livro("Sexologia parte 2", "Peter", 2024, "Editora Dos Rapazes");
        biblioteca.cadastrarLivro(livro4);


        // Exemplo de cadastro de usuário
        Usuario aluno1 = new Aluno("Walter Hl", "123456789", new Date(), 1, "Escola X");
        biblioteca.cadastrarUsuario(aluno1);

        // Exemplo de empréstimo
        biblioteca.realizarEmprestimo(aluno1, livro1);

        // Exemplo de devolução
//        biblioteca.realizarDevolucao(aluno1, livro1);

        // Exemplo de impressão de livros disponíveis
        biblioteca.imprimirLivrosDisponiveis();

        aluno1.imprimirLivros();
    }
}
