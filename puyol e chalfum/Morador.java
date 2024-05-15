import java.util.Date;

public class Morador extends Usuario {
    public Morador(String nome, String cpf, Date dataNascimento, int id) {
        super(nome, cpf, dataNascimento, id);
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