package htw.berlin.webtech.Projekt.web;

import htw.berlin.webtech.Projekt.service.TestService;
import htw.berlin.webtech.Projekt.web.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TestRestController {


    private final TestService testService;

    public TestRestController(TestService testService) {
        this.testService = testService;
    }


    @GetMapping(path = "/api/v1/tests")
    public ResponseEntity<List<Test>> fetchTests() {
       return ResponseEntity.ok(testService.findAll()); }

}
