package seedu.spendswift;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class CurrencyConverter {

    private static final String API_KEY = System.getenv("EXCHANGE_API_KEY");  // Load API key from environment
    private static final String BASE_URL = "https://api.exchangeratesapi.io/latest";

    private Map<String, Double> exchangeRates;

    public CurrencyConverter(String baseCurrency) throws IOException {
        fetchExchangeRates(baseCurrency);
    }

    private void fetchExchangeRates(String baseCurrency) throws IOException {
        String urlString = BASE_URL + "?access_key=" + API_KEY + "&base=" + baseCurrency;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + connection.getResponseCode());
            }
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            JsonObject jsonObject = new Gson().fromJson(response.toString(), JsonObject.class);
            exchangeRates = new Gson().fromJson(jsonObject.get("rates"),
                                                new TypeToken<Map<String, Double>>(){}.getType());
        } finally {
            connection.disconnect();
        }
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        double rate = exchangeRates.get(toCurrency) / exchangeRates.get(fromCurrency);
        return amount * rate;
    }
}
