import java.util.Date;

public class Morador extends Usuario{

    //Construtora da sub-classe Morador, para utilizar dos mecanismos de Herança (vindos da classe Usuario)
    public Morador(String nome, String cpf, Date data_nasc, int id, Livro[] livros_alugados) {
        super(nome, cpf, data_nasc, id, new Livro[2]);
    }

    //Métodos da sub-classe Morador
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
