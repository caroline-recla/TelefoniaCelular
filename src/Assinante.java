import java.util.Date;

public abstract class Assinante {
    private long cpf;
    private String nome;
    private String numero;
    protected Chamada[] chamadas;
    protected int numChamadas;

    public Assinante(long cpf, String nome, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[10]; // Tamanho arbitrário para o vetor de chamadas
        this.numChamadas = 0;
    }

    public long getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }

    public void adicionarChamada(Chamada chamada) {
        if (numChamadas < chamadas.length) {
            chamadas[numChamadas++] = chamada;
        }
    }

    public abstract void fazerChamada(Date data, int duracao);
    public abstract void imprimirFatura(int mes);
}