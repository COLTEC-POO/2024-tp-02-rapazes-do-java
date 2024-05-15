import java.util.Date;

public class Professor extends Usuario {
    private String formacao;

    public Professor(String nome, String cpf, Date dataNascimento, int id, String formacao) {
        super(nome, cpf, dataNascimento, id);
        this.formacao = formacao;
    }

    public boolean devolverLivro(Livro livro) {
        // Implementar a lógica para devolver o livro
        return false;
    }

    public boolean pegarLivro(Livro livro) {
        // Implementar a lógica para pegar o livro em empréstimo
        return false;
    }
}
