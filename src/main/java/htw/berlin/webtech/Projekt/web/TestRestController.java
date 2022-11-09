package htw.berlin.webtech.Projekt.web;

import htw.berlin.webtech.Projekt.service.TestService;
import htw.berlin.webtech.Projekt.web.api.Test;
import htw.berlin.webtech.Projekt.web.api.TestCreateOrUpdateRequest;
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

    @GetMapping(path = "/api/v1/tests")
    public ResponseEntity<List<Test>> fetchTests() {
       return ResponseEntity.ok(testService.findAll()); }

    @GetMapping(path = "api/v1/tests/{id}")
    public ResponseEntity<Test> fetchTestById(@PathVariable Long id){
        var test = testService.findById(id);
        return test != null? ResponseEntity.ok(test) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "api/v1/tests")
    public ResponseEntity<Void> createTest(@RequestBody TestCreateOrUpdateRequest request) throws URISyntaxException {
        var test = testService.create(request);
        URI uri = new URI("api/v1/tests" + test.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "api/v1/tests/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable Long id, @RequestBody TestCreateOrUpdateRequest request){
        var test = testService.update(id, request);
        return test != null? ResponseEntity.ok(test) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "api/v1/tests/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        boolean successful = testService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
