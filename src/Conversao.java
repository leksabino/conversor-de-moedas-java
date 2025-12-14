import java.time.LocalDateTime;

public class Conversao {

    private String moedaOrigem;
    private String moedaDestino;
    private double valorOriginal;
    private double valorConvertido;
    private LocalDateTime dataHora;

    public Conversao(String origem, String destino, double valorOriginal, double valorConvertido) {
        this.moedaOrigem = origem;
        this.moedaDestino = destino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.dataHora = LocalDateTime.now();
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    @Override
    public String toString() {
        return dataHora + " | " +
                String.format("%.2f", valorOriginal) + " " + moedaOrigem +
                " → " +
                String.format("%.2f", valorConvertido) + " " + moedaDestino;
    }
}
