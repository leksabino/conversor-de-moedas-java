import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Conversor {

    private ApiService api = new ApiService();
    private Gson gson = new Gson();
    private List<Conversao> historico = new ArrayList<>();

    public Conversao converter(int opcao, double valor) {

        String json = api.buscarCotacaoUSD();
        RespostaApi resposta = gson.fromJson(json, RespostaApi.class);
        Map<String, Double> taxas = resposta.getConversionRates();

        String origem = "";
        String destino = "";
        double resultado = 0;

        switch (opcao) {
            case 1 -> { origem = "USD"; destino = "BRL"; resultado = valor * taxas.get("BRL"); }
            case 2 -> { origem = "BRL"; destino = "USD"; resultado = valor / taxas.get("BRL"); }
            case 3 -> { origem = "EUR"; destino = "BRL"; resultado = valor * taxas.get("BRL") / taxas.get("EUR"); }
            case 4 -> { origem = "BRL"; destino = "EUR"; resultado = valor * taxas.get("EUR") / taxas.get("BRL"); }
            case 5 -> { origem = "USD"; destino = "EUR"; resultado = valor * taxas.get("EUR"); }
            case 6 -> { origem = "EUR"; destino = "USD"; resultado = valor / taxas.get("EUR"); }
        }

        resultado = Math.round(resultado * 100.0) / 100.0;

        Conversao conversao = new Conversao(origem, destino, valor, resultado);
        historico.add(conversao);

        return conversao;
    }

    public List<Conversao> getHistorico() {
        return historico;
    }
}
