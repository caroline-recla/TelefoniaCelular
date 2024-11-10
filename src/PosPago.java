import java.util.Date;

public class PosPago extends Assinante {
    private float assinatura;

    public PosPago(long cpf, String nome, String numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, int duracao) {
        Chamada chamada = new Chamada(data, duracao);
        adicionarChamada(chamada);
        System.out.println("Chamada registrada.");
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura Pós-Pago:");
        System.out.println(this);
        float totalChamadas = 0;

        System.out.println("Chamadas:");
        for (int i = 0; i < numChamadas; i++) {
            if (chamadas[i].getData().getMonth() == mes - 1) {
                System.out.println(chamadas[i]);
                totalChamadas += chamadas[i].getDuracao() * 1.04f;
            }
        }
        System.out.println("Total de Chamadas: R$ " + totalChamadas);
        System.out.println("Assinatura: R$ " + assinatura);
        System.out.println("Total Fatura: R$ " + (totalChamadas + assinatura));
    }
}