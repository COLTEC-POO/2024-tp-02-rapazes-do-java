import java.util.Date;

public class Usuario {

    //Variáveis da super-classe Usuario pedidas no README
    private String nome;
    private String cpf;
    private Date data_nasc;
    private int id;
    private Livro[] livros_alugados;

    //Construtora da super-classe Usuario
    public Usuario(String nome, String cpf, Date data_nasc, int id, Livro[] livros_alugados){
        this.nome = nome;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
        this.id = id;
        this.livros_alugados = livros_alugados;
    }

    //Setter das Variáveis
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setData_nasc(Date data_nasc){
        this.data_nasc = data_nasc;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setLivros_alugados(Livro[] livros_alugados){
        this.livros_alugados = livros_alugados;
    }

    //Getter das variáveis
    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public Date getData_nasc(){
        return this.data_nasc;
    }

    public int getId(){
        return this.id;
    }

    public Livro[] getLivros_alugados(){
        return this.livros_alugados;
    }

    //Métodos da super-classe Usuario
    public boolean pegarLivro(Livro livro){  //Método para verificar se você tem espaço para pegar mais livros

        for(int i=0; i < livros_alugados.length; i++) {
            if (livros_alugados[i] == null) {  //Se o espaço estiver vazio, você consegue pegar este livro
                livros_alugados[i] = livro;
                livro.setEmprestado(true);
                return true;
            }
        }
        return false;  //Senão, não há espaço

    }

    boolean devolverLivro(Livro livro){  //Método para verificar se você possui o livro à ser devolvido

        for(int i=0; i < livros_alugados.length; i++){
            if(livros_alugados[i] == livro){  //Se o espaço estiver com o livro em questão, você devolverá
                livros_alugados[i] = null;
                livro.setEmprestado(false);
                return true;
            }
        }

        return false;  //Senão, o livro não foi encontrado

    }

    void imprimirLivros() {  //Método para mostrar os dados de todos os livros alugados pelo Usuario em questão

        System.out.println("Livros alugados pelo Usuario " + nome + ":");

        for (Livro livro : livros_alugados) {  //Criação de uma variável temporária para passar por todos os elementos de livros_alugados
            if (livro != null)  //Caso ache algum livro, todos os dados do mesmo, serão imprimidos na tela
                livro.imprimir();
        }

    }

}
