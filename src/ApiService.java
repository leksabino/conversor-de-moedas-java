import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private static final String API_KEY = "a9e34894f06b68dbab2a1cb2";

    public String buscarCotacaoUSD() {

        String endereco = "https://v6.exchangerate-api.com/v6/"
                + API_KEY + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar cotação", e);
        }
    }
}
