import java.util.Date;

public class Aluno extends Usuario{

    //Variáveis da sub-classe Aluno pedidas no README
    private String escola;

    //Construtora da sub-classe Aluno, para utilizar dos mecanismos de Herança (vindos da classe Usuario)
    public Aluno(String nome, String cpf,String escola, Date data_nasc, int id, Livro[] livros_alugados){
        super(nome, cpf, data_nasc, id, new Livro[5]);
        this.escola = escola;
    }

    //Setter da variavel
    public void setEscola(String escola){
        this.escola = escola;
    }

    //Getter da variavel
    public String getEscola(){
        return this.escola;
    }

    //Métodos da sub-classe Aluno
    public void realizarEmprestimo(Livro livro){  //Método para verificar se é possível realizar um empréstimo

        boolean emprestimo = pegarLivro(livro);  //Verifica se é possível realizar o empréstimo do livro;

        if(emprestimo)  //Caso retorne true, o empréstimo será realizado
            System.out.println("Empréstimo do livro " + livro + " realizado com sucesso!");

        else  //Caso contrário, não
            System.out.println("Não foi possível realizar o empréstimo do livro"  + livro +  ".");

    }

    public void realizarDevolucao(Livro livro){  //Método para verificar se é possível realizar a devolução

        boolean devolucao = devolverLivro(livro);  //Verifica se é possível realizar a devolução do livro;

        if(devolucao)  //Caso retorne true, a devolução será realizada
            System.out.println("Devolução do livro " + livro + " realizado com sucesso!");

        else  //Caso contrário, não
            System.out.println("Não foi possível realizar a devolução do livro"  + livro +  ".");

    }

}
