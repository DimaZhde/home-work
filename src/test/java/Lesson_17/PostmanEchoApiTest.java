import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;

public class PostmanEchoApiTest {
    private static final String BASE_URL = "https://postman-echo.com";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Проверка: GET Request Woops")
    public void testGetRequest() throws Exception {
        // Arrange
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/get?foo1=bar1&foo2=bar2"))
                .GET()
                .build();

        // Act
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET Response: " + response.body());

        // Assert
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertAll(
                () -> assertEquals("bar1", json.path("args").path("foo1").asText()),
                () -> assertEquals("bar2", json.path("args").path("foo2").asText())
        );
    }

    @Test
    @DisplayName("Проверка: POST Raw Text")
    public void testPostRawText() throws Exception {
        // Arrange
        String requestBody = "{\"test\":\"value\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Act
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("POST Raw Text Response: " + response.body());

        // Assert
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertEquals("value", json.path("json").path("test").asText());
    }

    @Test
    @DisplayName("Проверка: POST Form Data")
    public void testPostFormData() throws Exception {
        // Arrange
        String formData = "foo1=bar1&foo2=bar2";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/post"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(formData))
                .build();

        // Act
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("POST Form Data Response: " + response.body());

        // Assert
        assertEquals(200, response.statusCode());

        JsonNode json = objectMapper.readTree(response.body());
        assertAll(
                () -> assertEquals("bar1", json.path("form").path("foo1").asText()),
                () -> assertEquals("bar2", json.path("form").path("foo2").asText())
        );
    }

    @Test
    @DisplayName("Проверка: PUT Request")
    public void testPutRequest() throws Exception {
        // Arrange
        String requestBody = "This is expected to be sent back as part of response body.";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/put"))
                .header("Content-Type", "text/plain")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Act
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("PUT Response: " + response.body());

        // Assert
        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains(requestBody));
    }

    @Test
    @DisplayName("Проверка: PATCH Request")
    public void testPatchRequest() throws Exception {
        // Arrange
        String requestBody = "This is expected to be sent back as part of response body.";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/patch"))
                .header("Content-Type", "text/plain")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Act
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("PATCH Response: " + response.body());

        // Assert
        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains(requestBody));
    }

    @Test
    @DisplayName("Проверка: DELETE Request")
    public void testDeleteRequest() throws Exception {
        // Arrange
        String requestBody = "This is expected to be sent back as part of response body.";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/delete"))
                .header("Content-Type", "text/plain")
                .method("DELETE", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // Act
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("DELETE Response: " + response.body());

        // Assert
        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains(requestBody));
    }
}