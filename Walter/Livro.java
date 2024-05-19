import java.util.Date;

public class Livro {

    //Variável implementada por mim, para verificar se o livro está emprestado ou não
    private boolean emprestado;

    //Variáveis da classe Livro pedidas no README
    private String titulo;
    private String autor;
    private String editora;
    private Date ano_pub;

    //Construtora da classe Livro
    public Livro(String titulo, String autor, String editora, Date ano_pub, boolean emprestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_pub = ano_pub;
        this.emprestado = emprestado;
    }

    //Setter das Variáveis
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setEditora(String editora){
        this.editora = editora;
    }

    public void setAno_pub(Date ano_pub){
        this.ano_pub = ano_pub;
    }

    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

    //Getter das Variáveis
    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getEditora(){
        return this.editora;
    }

    public Date getAno_pub(){
        return this.ano_pub;
    }

    public boolean getEmprestado(){
        return this.emprestado;
    }

    //Método da classe Livro
    void imprimir() {  //Método para imprimir dados do livro

        System.out.println("=====================================\n");

        System.out.println("Dados do livro " + this.titulo + ":");
        System.out.println("Autor: " + this.autor);
        System.out.println("Editora: " + this.editora);
        System.out.println("Ano de publicação: " + this.ano_pub);

        System.out.println("=====================================\n");

    }

}
