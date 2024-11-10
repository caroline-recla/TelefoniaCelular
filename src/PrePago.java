import java.util.Date;

public class PrePago extends Assinante {

    private float creditos;

    private Recarga[] recargas;

    private int numRecargas;

    public PrePago(long cpf, String nome, String numero) {

        super(cpf, nome, numero);

        this.creditos = 0;

        this.recargas = new Recarga[10]; // Tamanho arbitrário

        this.numRecargas = 0;

    }

    public void fazerChamada(Date data, int duracao) {

        if (creditos >= duracao * 1.45) {

            Chamada chamada = new Chamada(data, duracao);

            adicionarChamada(chamada);

            creditos -= duracao * 1.45;

            System.out.println("Chamada registrada.");

        } else {

            System.out.println("Créditos insuficientes para a chamada.");

        }

    }

    public void recarregar(Date data, float valor) {

        if (numRecargas < recargas.length) {

            Recarga recarga = new Recarga(data, valor);

            recargas[numRecargas++] = recarga;

            creditos += valor;

            System.out.println("Recarga realizada.");

        } else {

            System.out.println("Limite de recargas atingido.");

        }

    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura Pré-Pago:");
        System.out.println(this);
        float totalChamadas = 0;
        float totalRecargas = 0;

        System.out.println("Chamadas:");
        for (int i = 0; i < numChamadas; i++) {
            if (chamadas[i].getData().getMonth() == mes - 1) {
                System.out.println(chamadas[i]);
                totalChamadas += chamadas[i].getDuracao() * 1.45f;
            }
        }

        System.out.println("Recargas:");
        for (int i = 0; i < numRecargas; i++) {
            if (recargas[i].getData().getMonth() == mes - 1) {
                System.out.println(recargas[i]);
                totalRecargas += recargas[i].getValor();
            }
        }

        System.out.println("Total de Chamadas: R$ " + totalChamadas);
        System.out.println("Total de Recargas: R$ " + totalRecargas);
        System.out.println("Créditos Restantes: R$ " + creditos);
    }

}
