import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Biblioteca {

    //Variáveis implementadas por mim
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    //Variáveis da classe Biblioteca pedidas no README
    LinkedList<Livro> livros;
    LinkedList<Usuario> usuarios;
    String nome;

    public Biblioteca(String nome){
        livros = new LinkedList<>();
        usuarios = new LinkedList<>();
        this.nome = nome;
    }

    public static void main(String[] args){

        Biblioteca biblioteca = new Biblioteca("Rapazes do Java");

        Scanner scanMain = new Scanner(System.in);

        int opcoes = -1;
        do {
            System.out.println("=========================");
            System.out.println("MENU DE OPÇÕES BIBLIOTECA");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Pegar livro");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Ver livros de um usuario");
            System.out.println("6 - Ver livros disponíveis");
            System.out.println("7 - Ver usuarios cadastrados");
            System.out.println("0 - Sair");
            System.out.println("=========================");

            opcoes = scanMain.nextInt();

            switch (opcoes) {
                case 1:
                    biblioteca.cadastrarLivro();
                    break;
                case 2:
                    biblioteca.cadastrarUsuario();
                    break;
                case 3:
                    biblioteca.realizarEmprestimo();
                    break;
                case 4:
                    biblioteca.realizarDevolucao();
                    break;
                case 5:
                    biblioteca.emprestadosUsuario();
                    break;
                case 6:
                    biblioteca.imprimirLivros();
                    break;
                case 7:
                    biblioteca.imprimirUsuarios();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    System.out.println();
                    break;
            }
        }while(opcoes != 0);

    }

    //Métodos da classe Biblioteca pedidos no README
    public void cadastrarLivro(){

        System.out.println();
        System.out.println("Digite os seguintes dados do livro a ser cadastrado: ");
        System.out.println();

        System.out.print("Titulo do Livro: ");  //Peço o titulo a ser cadastrado
        String titulo = scan.nextLine();

        System.out.print("Autor do Livro: ");  //Peço o autor a ser cadastrado
        String autor = scan.nextLine();

        System.out.print("Editora do Livro: ");  //Peço a editora a ser cadastrado
        String editora = scan.nextLine();

        boolean sucesso = false;
        Date ano_pub = null;
        System.out.print("Ano de publicação do livro(dd/MM/yyyy): ");  //Peço a data de publicação do livro a ser cadastrado em formato de string

        while(!sucesso) {
            String str_datapub = scan.nextLine();

            try {  //Verifico se foi digitado em uma string, o formato pedido para Date, caso tenha sido, ele é convertido à uma variável tipo Date
                ano_pub = formatador.parse(str_datapub);
                sucesso = true;
            } catch (ParseException e) {  //Caso não, simplesmente repete
                System.out.println("Formato de data inválido. Favor usar (dd/MM/yyyy).");
                System.out.print("Ano de publicação do livro(dd/MM/yyyy): ");  //Peço a data de publicação do livro a ser cadastrado em formato de string
            }
        }

        Livro livro = new Livro(titulo, autor, editora, ano_pub, false);  //Criando uma instância de livro com os dados coletados, com emprestado = false
        livros.add(livro);  //Adicionando à lista, a instância com os dados

        System.out.println();
        System.out.println("Livro " + titulo + " cadastrado com sucesso!");
        System.out.println();

    }   //Método para cadastrar livros à biblioteca

    public void cadastrarUsuario(){

        System.out.println();
        System.out.println("Digite os seguintes dados do Usuario: ");
        System.out.println();

        System.out.print("Tipo de usuario a ser cadastrado(1 - Morador, 2 - Aluno, 3 - Professor): ");

        int tipo = 0;
        while(true) {  //Verificação até que o tipo de usuario digitado, realmente exista
            tipo = scan.nextInt();

            if(tipo < 1 || tipo > 3){
                System.out.println("Digite um tipo válido.");
                System.out.println();
            }

            else
                break;
        }

        scan.nextLine();

        System.out.print("Nome do usuario: ");  //Peço o nome a ser cadastrado
        String nome = scan.nextLine();

        System.out.print("Cpf do usuario(XXX.XXX.XXX-XX): ");  //Peço o cpf a ser cadastrado
        String cpf = scan.nextLine();

        if(!validarCpf(cpf)) {
            System.out.println("Cpf invalido.");
            System.out.println();
            return;
        }

        for(Usuario u : usuarios){
            if(u.getCpf().equals(cpf)) {  //Verifica se o cpf já está sendo utilizado por outro usuario
                System.out.println("Este cpf já está sendo utilizado.");
                System.out.println();
                return;
            }
        }

        System.out.print("Id do usuario: ");  //Peço o id a ser cadastrado
        int id = scan.nextInt();

        for(Usuario u : usuarios){
            if(u.getId() == id) {  //Verifica se o id já está sendo utilizado por outro usuario
                System.out.println("Este id já está sendo utilizado.");
                System.out.println();
                return;
            }
        }

        boolean sucesso = false;
        Date data_nasc = null;

        scan.nextLine();

        System.out.print("Data de nascimento do usuario(dd/MM/yyyy): ");  //Peço a data de nascimento a ser cadastrada
        while(!sucesso) {  //Loop de verificação para data de nascimento
            String str_datanasc = scan.nextLine();

            try {
                data_nasc = formatador.parse(str_datanasc);  //Caso esteja no formato pedido, é transformado em uma variável date
                sucesso = true;
            } catch (ParseException e) {  //ParseException é uma exceção lançada ao ocorrer um erro na conversão de uma string ou data para outro tipo de dado
                System.out.println("Formato de data inválido. Favor usar (dd/MM/yyyy).");
                System.out.print("Data de nascimento do usuario(dd/MM/yyyy): ");
            }
        }

        Usuario usuario = null;

        switch(tipo){

            case 1: //Morador
                usuario = new Morador(nome, cpf, data_nasc, id, new Livro[2]);
                break;

            case 2: //Aluno
                System.out.print("Escola do usuario: ");  //Peço a escola que o usuario estuda, caso seja do tipo 2
                String escola = scan.nextLine();

                usuario = new Aluno(nome, cpf, escola, data_nasc, id, new Livro[5]);
                break;

            case 3: //Professor
                System.out.print("Formação do usuario: ");  //Peço a formação do usuario, caso seja do tipo 3
                String formacao = scan.nextLine();

                usuario = new Professor(nome, cpf, formacao, data_nasc, id, new Livro[10]);
                break;

        }

        usuarios.add(usuario);
        System.out.println();
        System.out.println("Usuario " + nome + " cadastrado com sucesso!");
        System.out.println();

    }  //Método para cadastrar usuarios à biblioteca

    public void realizarEmprestimo(){

        //Verificando o usuario
        System.out.println();
        System.out.print("Digite o id do usuario: ");  //Pegando o id do usuario para buscá-lo no cadastro da biblioteca
        int id_usuario = scan.nextInt();

        Usuario usuario = null;

        for(Usuario u : usuarios){  //Passa por todos os usuarios cadastrados
            if(u.getId() == id_usuario) {  //Caso o id do usuario atual( em u), seja igual ao id do usuario digitado anteriormente, será inicializada a instância usuario
                usuario = u;
                break;
            }
        }

        if(usuario == null) {
            System.out.println("Usuario não foi encontrado.");
            System.out.println();
            return;
        }

        scan.nextLine();

        //Verificando o livro
        System.out.print("Digite o titulo do livro a ser pego: ");
        String titulo_livro = scan.nextLine();

        Livro livro = null;

        for(Livro l : livros){  //Passa por todos os livros cadastrados
            if(l.getTitulo().equals(titulo_livro)) {  //Caso o livro na variável l, tenha o mesmo título do livro digitado anteriormente, será inicializada a instância livro
                livro = l;
                break;
            }
        }

        if(livro == null) {
            System.out.println("Livro não foi encontrado.");
            System.out.println();
            return;
        }

        //Realizando ou não o empréstimo
        if(livro.getEmprestado()){
            System.out.println("Este livro já pertence a outro usuario.");
            System.out.println();
            return;
        }

        if(!usuario.pegarLivro(livro)) {  //Caso ele não tenha mais espaço para pegar livros
            System.out.println("O usuario não tem mais limite suficiente para empréstimo de livros.");
            System.out.println();
            return;
        }

        livro.setEmprestado(true);  //Caso tenha, o livro será settado como emprestado

        System.out.println();
        System.out.println("Empréstimo do livro " + livro.getTitulo() + " para o usuario " + usuario.getNome() + " efetuado com sucesso!");
        System.out.println();

    }  //Método para iniciar processo de empréstimo de livros

    public void realizarDevolucao(){

        //Verificando o usuario
        System.out.println();
        System.out.print("Digite o id do usuario: ");  //Pegando o id do usuario para buscá-lo no cadastro da biblioteca
        int id_usuario = scan.nextInt();

        Usuario usuario = null;

        for(Usuario u : usuarios){  //Passa por todos os usuarios cadastrados
            if(u.getId() == id_usuario) {  //Caso o id do usuario atual( em u), seja igual ao id do usuario digitado anteriormente, será inicializada a instância usuario
                usuario = u;
                break;
            }
        }

        if(usuario == null) {
            System.out.println("Usuario não foi encontrado.");
            System.out.println();
            return;
        }

        //Verificando o livro
        System.out.print("Digite o titulo do livro a ser devolvido: ");
        scan.nextLine();
        String titulo_livro = scan.nextLine();

        Livro livro = null;

        for(Livro l : livros){  //Passa por todos os livros cadastrados
            if((l.getTitulo()).equals(titulo_livro)) {  //Caso o livro na variável l, tenha o mesmo título do livro digitado anteriormente, será inicializada a instância livro
                livro = l;
                break;
            }
        }

        if(livro == null) {
            System.out.println("Livro " + titulo_livro + " não foi encontrado.");
            System.out.println();
            return;
        }

        //Realizando ou não a devolução
        if(!usuario.devolverLivro(livro)) {  //Caso ele não tenha o livro em seu cadastro
            System.out.println("O usuario não tem o livro " + titulo_livro + " em seu cadastro.");
            System.out.println();
            return;
        }

        livro.setEmprestado(false);  //Caso tenha, o livro será settado como não emprestado

        System.out.println("Devolução do livro " + titulo_livro + " realizada com sucesso!");
        System.out.println();

    }  //Método para iniciar processo de devolução de livros

    public void imprimirLivros(){

        System.out.println();

        if(livros.isEmpty()){  //Verifica se a lista livros está vazia
            System.out.println("Não há livros na biblioteca.");
            System.out.println();
            return;
        }

        System.out.println("Livros disponíveis na biblioteca: ");
        System.out.println();

        for(Livro livro : livros){  //Imprime todos os livros disponíveis
            if(!livro.getEmprestado())
                livro.imprimir();
        }

        System.out.println();

    }  //Método para imprimir todos os livros disponíveis na biblioteca

    //Métodos da classe Biblioteca implementados por mim
    public void emprestadosUsuario(){

        System.out.print("Id do usuario: ");
        int id = scan.nextInt();

        Usuario usuario = null;
        boolean sucesso = false;

        for(Usuario u : usuarios){
            if(u.getId() == id) {  //Caso o id digitado seja igual ao dentro do for de busca, o usuário será definido
                usuario = u;
                sucesso = true;
                break;
            }
        }

        if(!sucesso) {
            System.out.println("Usuario não encontrado.");
            System.out.println();
            return;
        }

        System.out.println();
        usuario.imprimirLivros();

    }  //Método para imprimir todos os livros de um determinado usuario

    public void imprimirUsuarios(){

        System.out.println();
        System.out.println("Usuarios presentes na biblioteca: ");

        if(usuarios.isEmpty()){  //Verifica se a lista livros está vazia
            System.out.println("Não há usuários cadastrados na biblioteca.");
            System.out.println();
            return;
        }

        for(Usuario u: usuarios)
            System.out.println("Nome: " + u.getNome() + "; Id: " + u.getId());

        System.out.println();

    }  //Método para imprimir usuarios cadastrados na biblioteca

    public boolean validarCpf(String cpf){

        boolean cpfValido = true;

        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            cpfValido = false;

        // Verifica se todos os dígitos são iguais
        boolean allDigitsEqual = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual)
            cpfValido = false;

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9)
            digit1 = 0;

        // Verifica o primeiro dígito verificador
        if ((cpf.charAt(9) - '0') != digit1)
            cpfValido = false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9)
            digit2 = 0;

        // Verifica o segundo dígito verificador
        if ((cpf.charAt(10) - '0') != digit2)
            cpfValido = false;

        return cpfValido;

    }  //Método para verificar se o cpf é valido

}
