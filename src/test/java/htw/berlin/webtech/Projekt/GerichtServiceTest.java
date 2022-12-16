package htw.berlin.webtech.Projekt;

import htw.berlin.webtech.Projekt.persistence.IGerichtRepository;
import htw.berlin.webtech.Projekt.service.GerichtService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GerichtServiceTest {

    @Autowired
    private GerichtService service;

    @MockBean
    private IGerichtRepository repository;

    @Test
    @DisplayName("this is a test test")
    void testTest() {
        assertEquals("service", "service");
    }
}
