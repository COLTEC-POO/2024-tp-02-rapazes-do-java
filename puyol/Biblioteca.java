import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private String nome;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso: " + livro.getTitulo());
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + usuario.getNome());
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        // Verificar se o livro está disponível na biblioteca
        if (livros.contains(livro)) {
            // Verificar se o usuário pode pegar mais livros emprestados
            if (usuario.pegarLivro(livro)) {
                System.out.println("Empréstimo realizado com sucesso: " + livro.getTitulo());
            } else {
                System.out.println("Empréstimo não realizado. Verifique se o usuário pode pegar mais livros emprestados.");
            }
        } else {
            System.out.println("Empréstimo não realizado. O livro não está disponível na biblioteca.");
        }
    }

    public void realizarDevolucao(Usuario usuario, Livro livro) {
        if (usuario.devolverLivro(livro)) {
            System.out.println("Devolução realizada com sucesso: " + livro.getTitulo());
        } else {
            System.out.println("Devolução não realizada. Verifique se o usuário possui o livro.");
        }
    }

    public void imprimirLivrosDisponiveis() {
        System.out.println("Livros disponíveis na biblioteca:");
        for (Livro livro : livros) {
            livro.imprimir();
            System.out.println();
        }
    }
}