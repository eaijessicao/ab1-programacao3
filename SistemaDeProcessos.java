import java.util.Scanner;

class Pessoa {
    private String nome;
    private String cpf;

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
}

class Advogado {
    private String nome;
    private String oab;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOab() {
        return oab;
    }
    public void setOab(String oab) {
        this.oab = oab;
    }
}

class Processo {
    private String numeroProcesso;
    private String descricao;
    private Pessoa reclamante;
    private Pessoa reclamada;
    private Advogado advogado;

    public String getNumeroProcesso() {
        return numeroProcesso;
    }
    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getReclamante() {
        return reclamante;
    }
    public void setReclamante(Pessoa reclamante) {
        this.reclamante = reclamante;
    }

    public Pessoa getReclamada() {
        return reclamada;
    }
    public void setReclamada(Pessoa reclamada) {
        this.reclamada = reclamada;
    }

    public Advogado getAdvogado() {
        return advogado;
    }
    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public void exibir() {
        System.out.println("---------------------------------");
        System.out.println("Processo N.: " + numeroProcesso);
        System.out.println("Descricao: " + descricao);
        System.out.println("Reclamante: " + reclamante.getNome() + " (CPF: " + reclamante.getCpf() + ")"); 
        System.out.println("Reclamada: " + reclamada.getNome() + " (CPF: " + reclamada.getCpf() + ")");   
        System.out.println("Advogado: " + advogado.getNome() + " (OAB: " + advogado.getOab() + ")");
        System.out.println("---------------------------------");
    }
}

public class SistemaDeProcessos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Processo[] processos = new Processo[100];
        int qtd = 0;

        int opcao = 0;
        while (opcao != 3) {
            System.out.println("\n== MENU ==");
            System.out.println("1. Cadastrar Processo");
            System.out.println("2. Listar Processos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma das opções acima: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    Processo p = new Processo();
                    Pessoa reclamante = new Pessoa();
                    Pessoa reclamada = new Pessoa();
                    Advogado adv = new Advogado();

                    System.out.print("Numero do processo: ");
                    p.setNumeroProcesso(teclado.nextLine());
                    System.out.print("Descricao: ");
                    p.setDescricao(teclado.nextLine());

                    System.out.print("Nome do reclamante: ");
                    reclamante.setNome(teclado.nextLine());
                    System.out.print("CPF do reclamante: "); 
                    reclamante.setCpf(teclado.nextLine()); 
                    p.setReclamante(reclamante);

                    System.out.print("Nome do reclamado: ");
                    reclamada.setNome(teclado.nextLine());
                    System.out.print("CPF do reclamado: "); 
                    reclamada.setCpf(teclado.nextLine()); 
                    p.setReclamada(reclamada);

                    System.out.print("Nome do advogado: ");
                    adv.setNome(teclado.nextLine());
                    System.out.print("OAB: ");
                    adv.setOab(teclado.nextLine());
                    p.setAdvogado(adv);

                    processos[qtd] = p;
                    qtd++;

                    System.out.println("Processo cadastrado!");
                    break;

                case 2:
                    if (qtd == 0) {
                        System.out.println("Nenhum processo cadastrado.");
                    } else {
                        for (int i = 0; i < qtd; i++) {
                            processos[i].exibir();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Fim do programa.");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }

        teclado.close();
    }
}