import java.util.Date;

public class Professor extends Usuario{

    //Variáveis da sub-classe Professor pedidas no README
    private String formacao;

    //Construtora da sub-classe Professor, para utilizar dos mecanismos de Herança (vindos da classe Usuario)
    public Professor(String nome, String cpf, String formacao, Date data_nasc, int id, Livro[] livros_alugados){
        super(nome, cpf, data_nasc, id, new Livro[10]);
        this.formacao = formacao;
    }

    //Setter da variavel
    public void setFormacao(String formacao){
        this.formacao = formacao;
    }

    //Getter da variavel
    public String getFormacao(){
        return this.formacao;
    }

    //Métodos da sub-classe Professor
    public void realizarEmprestimo(Livro livro){  //Método para verificar se é possível realizar um empréstimo

        if(pegarLivro(livro)  //Caso retorne true, o empréstimo será realizado
            System.out.println("Empréstimo do livro " + livro + " realizado com sucesso!");

        else  //Caso contrário, não
            System.out.println("Não foi possível realizar o empréstimo do livro"  + livro +  ".");

    }

    public void realizarDevolucao(Livro livro){  //Método para verificar se é possível realizar a devolução

        if(devolverLivro(livro))  //Caso retorne true, a devolução será realizada
            System.out.println("Devolução do livro " + livro + " realizado com sucesso!");

        else  //Caso contrário, não
            System.out.println("Não foi possível realizar a devolução do livro"  + livro +  ".");

    }

}
