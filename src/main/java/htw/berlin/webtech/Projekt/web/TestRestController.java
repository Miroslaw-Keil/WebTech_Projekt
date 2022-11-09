package htw.berlin.webtech.Projekt.web;

import htw.berlin.webtech.Projekt.service.TestService;
import htw.berlin.webtech.Projekt.web.api.Test;
import htw.berlin.webtech.Projekt.web.api.TestCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class TestRestController {

    @Autowired
    TestService testService;

/*
    public TestRestController(TestService testService) {
        this.testService = testService;
    }
*/

    @GetMapping(path = "/api/v1/tests")
    public ResponseEntity<List<Test>> fetchTests() {
       return ResponseEntity.ok(testService.findAll()); }

    @GetMapping(path = "api/v1/tests/{id}")
    public ResponseEntity<Test> fetchTestById(@PathVariable Long id){
        var test = testService.findById(id);
        return test != null? ResponseEntity.ok(test) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "api/v1/tests")
    public ResponseEntity<Void> createTest(@RequestBody TestCreateRequest request) throws URISyntaxException {
        var test = testService.create(request);
        URI uri = new URI("api/v1/tests" + test.getId());
        return ResponseEntity.created(uri).build();
    }

}
