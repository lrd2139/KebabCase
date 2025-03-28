package dev.coms4156.project.kebabcase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringJUnitConfig
class IndexControllerIntegrationTests {

  @Container
  @ServiceConnection
  private static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
      .withDatabaseName("testdb")
      .withUsername("testuser")
      .withPassword("testpass");

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void testIndexEndpointRoot() {
    // Arrange
    String url = "http://localhost:" + port + "/";

    // Act
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    // Assert
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Welcome!");
  }

  @Test
  void testIndexEndpointIndex() {
    // Arrange
    String url = "http://localhost:" + port + "/index";

    // Act
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    // Assert
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Welcome!");
  }

  @Test
  void testIndexEndpointHome() {
    // Arrange
    String url = "http://localhost:" + port + "/home";

    // Act
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    // Assert
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Welcome!");
  }
}
