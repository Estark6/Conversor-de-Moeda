import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public DeterminaMoeda converterMoeda(String moedaBase, String moedaAlvo, double moeda) {
        String Key = "fb28bb613ee85036ea17958f";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" +
                Key + "/pair/" + moedaBase + "/" + moedaAlvo + "?amount=" + moeda);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui converter os valores :/");
        }

        return new Gson().fromJson(response.body(), DeterminaMoeda.class);

    }
}