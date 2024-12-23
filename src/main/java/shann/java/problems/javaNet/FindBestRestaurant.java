package shann.java.problems.javaNet;

// given a webservice you have to consume that find the best restaurant for that city
// webService http:://myPlacesToEat.com/outlets?city={cityName}
// response will have pages, total-number-of-pages, total and data
// data contains city name estimateCost and userRating
// userRating to have averageRating and vote

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

// You have to find the best outlet for a given and city and with cost asked by user as atmost cost,
// if estimate is same then prefered restaurant will be one with better rating.
// TODO
public class FindBestRestaurant {

  public static void main(String[] args) {
    FindBestRestaurant findBestRestaurant = new FindBestRestaurant();
    // Set the custom directory for WireMock stub files
    String stubsDirectory = "src/main/resources/stubs";
    // Replace with your desired location
    WireMockServer wireMockServer =
        new WireMockServer(
            WireMockConfiguration.wireMockConfig()
                    .port(8080)
                    .withRootDirectory(stubsDirectory));
    try {
      wireMockServer.start();
      stubFor(
          get(urlEqualTo("/outlets"))
              .withQueryParam("city", equalTo("Bangalore"))
              .willReturn(
                  aResponse()
                      //.withBodyFile("bestRestaurant.json")
                      //.withBody("{\"data\":[{\"city\":\"Bangalore\",\"estimateCost\":1000,\"userRating\":{\"averageRating\":4.5,\"vote\":100}}]}")
                          .withBody("done")
                          .withHeader("Content-Type", "application/json")));
      findBestRestaurant.extractBestRestaurant();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      wireMockServer.stop();
    }
  }

  private void extractBestRestaurant() throws IOException {

    URL url = new URL("http://localhost:8080/outlets?city=Bangalore");
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    httpURLConnection.setRequestMethod("GET");
    httpURLConnection.setRequestProperty("Content-Type", "application/json");
    httpURLConnection.setRequestProperty("Accept", "application/json");
    httpURLConnection.setDoOutput(true);
    httpURLConnection.setDoInput(true);
    httpURLConnection.connect();
    int responseCode = httpURLConnection.getResponseCode();
    if (responseCode == HttpsURLConnection.HTTP_OK) {
      BufferedReader bufferedReader =
          new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
      bufferedReader.lines().forEach(System.out::println);
    } else {
      System.out.println("response code is " + responseCode);
      System.out.println(httpURLConnection.getResponseMessage());
    }
  }
}
