import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Telefonia sistemaTelefonia = new Telefonia();

        // Lista assinantes
        System.out.println("=== Listagem de Assinantes ===");
        sistemaTelefonia.listarAssinante();

        // Imprime fatura para o mês atual (considerando o sistema de indexação de meses de 0 a 11)
        int mesAtual = new Date().getMonth() + 1;
        System.out.println("\n=== Faturas do Mês " + mesAtual + " ===");
        sistemaTelefonia.imprimirFaturas();

        System.out.println("\nTestes concluídos.");
    }
}