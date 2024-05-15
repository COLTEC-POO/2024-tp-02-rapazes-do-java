import java.util.Date;

public abstract class Usuario {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private int id;
    public Livro[] livrosAlugados;

    public Usuario(String nome, String cpf, Date dataNascimento, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.id = id;
        this.livrosAlugados = new Livro[10]; // Tamanho máximo para professores
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro[] getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(Livro[] livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }

    public abstract boolean devolverLivro(Livro livro);

    public abstract boolean pegarLivro(Livro livro);

    public void imprimirLivros() {
        System.out.println("Livros alugados por " + nome + ":");
        for (Livro livro : livrosAlugados) {
            if (livro != null) {
                livro.imprimir();
                System.out.println();
            }
        }
    }
}
