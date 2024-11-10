import java.util.Date;

import java.util.Scanner;

public class Telefonia {
    private PrePago[] prePagos;
    private int numPrePagos;
    private PosPago[] posPagos;
    private int numPosPagos;

    public Telefonia() {
        prePagos = new PrePago[10];
        posPagos = new PosPago[10];
        numPrePagos = 0;
        numPosPagos = 0;

    }

    public void cadastrarAssinante() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de assinante (1 para Pré-pago, 2 para Pós-pago):");
        int tipo = scanner.nextInt();

        System.out.println("Digite o CPF do assinante sem pontos ou traços:");
        long cpf = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Digite o nome do assinante:");
        String nome = scanner.nextLine();

        System.out.println("Digite o número do telefone:");
        String numero = scanner.nextLine();

        if (tipo == 1) {
            if (numPrePagos < prePagos.length) {
                prePagos[numPrePagos++] = new PrePago(cpf, nome, numero);
                System.out.println("Assinante pré-pago cadastrado.");

            } else {
                System.out.println("Limite de assinantes pré-pagos atingido.");
            }

        } else if (tipo == 2) {

            System.out.println("Digite o valor da assinatura:");
            float assinatura = scanner.nextFloat();

            if (numPosPagos < posPagos.length) {
                posPagos[numPosPagos++] = new PosPago(cpf, nome, numero, assinatura);
                System.out.println("Assinante pós-pago cadastrado.");

            } else {
                System.out.println("Limite de assinantes pós-pagos atingido.");
            }

        } else {
            System.out.println("Tipo de assinante inválido.");
        }

    }

    public void listarAssinante() {
        System.out.println("Lista de assinantes:");

        for (int i = 0; i < numPrePagos; i++) {
            System.out.println(prePagos[i]);
        }

        for (int i = 0; i < numPosPagos; i++) {
            System.out.println(posPagos[i]);
        }

    }

    public void fazerChamada() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de assinante (1 para Pré-pago, 2 para Pós-pago):");
        int tipo = scanner.nextInt();

        System.out.println("Digite o CPF do assinante:");
        long cpf = scanner.nextLong();

        System.out.println("Digite a data da chamada (em milissegundos):");
        Date data = new Date(scanner.nextLong());

        System.out.println("Digite a duração da chamada em minutos:");
        int duracao = scanner.nextInt();

        if (tipo == 1) {
            PrePago pp = localizarPrePago(cpf);

            if (pp != null) {
                pp.fazerChamada(data, duracao);
            } else {
                System.out.println("Assinante pré-pago não encontrado.");
            }

        } else if (tipo == 2) {
            PosPago pp = localizarPosPago(cpf);

            if (pp != null) {
                pp.fazerChamada(data, duracao);
            } else {
                System.out.println("Assinante pós-pago não encontrado.");
            }

        }

    }

    public PrePago localizarPrePago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (prePagos[i].getCpf() == cpf) {
                return prePagos[i];
            }
        }
        return null;
    }

    public PosPago localizarPosPago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (posPagos[i].getCpf() == cpf) {
                return posPagos[i];
            }
        }
        return null;
    }

    public void fazerRecarga() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante pré-pago:");

        long cpf = scanner.nextLong();
        PrePago pp = localizarPrePago(cpf);

        if (pp != null) {
            System.out.println("Digite a data da recarga (em milissegundos):");
            Date data = new Date(scanner.nextLong());
            System.out.println("Digite o valor da recarga:");
            float valor = scanner.nextFloat();
            pp.recarregar(data, valor);

        } else {
            System.out.println("Assinante pré-pago não encontrado.");

        }

    }

    public void imprimirFaturas() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o mês para as faturas:");

        int mes = scanner.nextInt();

        for (int i = 0; i < numPrePagos; i++) {
            prePagos[i].imprimirFatura(mes);
        }

        for (int i = 0; i < numPosPagos; i++) {
            posPagos[i].imprimirFatura(mes);
        }

    }

    public static void main(String[] args) {

        Telefonia telefonia = new Telefonia();

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {

            System.out.println("\nMenu:");

            System.out.println("1. Cadastrar assinante");

            System.out.println("2. Listar assinantes");

            System.out.println("3. Fazer chamada");

            System.out.println("4. Fazer recarga");

            System.out.println("5. Imprimir faturas");

            System.out.println("6. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {

                case 1:
                    telefonia.cadastrarAssinante();
                    break;

                case 2:
                    telefonia.listarAssinante();
                    break;

                case 3:
                    telefonia.fazerChamada();
                    break;

                case 4:
                    telefonia.fazerRecarga();
                    break;

                case 5:
                    telefonia.imprimirFaturas();
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        }

    }

}

