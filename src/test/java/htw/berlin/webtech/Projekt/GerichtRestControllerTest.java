package htw.berlin.webtech.Projekt;

import htw.berlin.webtech.Projekt.service.GerichtService;
import htw.berlin.webtech.Projekt.web.GerichtRestController;
import htw.berlin.webtech.Projekt.web.api.Gericht;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GerichtRestController.class)
public class GerichtRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GerichtService gerichtService;

    @Test
    @DisplayName("should return found gerichte from gericht service")
    void should_return_found_gericht_from_gericht_service() throws Exception {
        // given
        var gerichte = List.of(
                new Gericht(1, "Spaghetti Carbonara", 45, false, "Abend"),
                new Gericht(2, "Avocadotoast", 5, true, "Morgen")
        );
        doReturn(gerichte).when(gerichtService).findAll();

        // when
        mockMvc.perform(get("/api/v1/gerichte"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Spaghetti Carbonara"))
                .andExpect(jsonPath("$[0].zubereitungsdauer").value(45))
                .andExpect(jsonPath("$[0].vegan").value(false))
                .andExpect(jsonPath("$[0].tageszeit").value("Abend"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Avocadotoast"))
                .andExpect(jsonPath("$[1].zubereitungsdauer").value(5))
                .andExpect(jsonPath("$[1].vegan").value(true))
                .andExpect(jsonPath("$[1].tageszeit").value("Morgen"));
    }

    @Test
    @DisplayName("should return 404 if gericht is not found")
    void should_return_404_if_gericht_is_not_found() throws Exception {
        // given
        doReturn(null).when(gerichtService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/gerichte/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a gericht")
    void should_return_201_http_status_and_location_header_when_creating_a_gericht() throws Exception {
        // given
        String gerichtToCreateAsJson = "{\"name\": \"Ketchup\", \"zubereitungsdauer\": 1, \"vegan\": true, \"tageszeit\": \"Mittag\"}";
        var gericht = new Gericht(123, null, 0, false, null);
        doReturn(gericht).when(gerichtService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/gerichte")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gerichtToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/gerichte/" + gericht.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(gericht.getId()))));

    }

//    @Test
//    @DisplayName("should validate create gericht request")
//    void should_validate_create_gericht_request() throws Exception {
//        // given
//        String gerichtToCreateAsJson = "{\"name\": \"Ketchup\", \"zubereitungsdauer\": 1, \"vegan\": true, \"tageszeit\": \"Mittag\"}";
//        var gericht = new Gericht(123, null, 0, false, null);
//        doReturn(gericht).when(gerichtService).create(any());
//
//        // when
//        mockMvc.perform(
//                post("/api/v1/gerichte")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(gerichtToCreateAsJson)
//                // then
//                .andExpect(status().isBadRequest());
//    }
}
