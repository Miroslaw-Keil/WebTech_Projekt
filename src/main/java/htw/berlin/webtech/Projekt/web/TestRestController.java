package htw.berlin.webtech.Projekt.web;

import htw.berlin.webtech.Projekt.web.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TestRestController {

    private List<Test> tests;

    public TestRestController() {

        tests = new ArrayList<>();
        tests.add(new Test(1, "Pizza", 25, false, "abends"));
        tests.add(new Test(2, "Avocado-Sandwich", 5,true, "fruehs"));
        tests.add(new Test(3,"Com Xao Thit Bo", 15, false, "mittags"));

    }


    @GetMapping(path = "/api/v1/tests")
    public ResponseEntity<List<Test>> fetchTests() { return ResponseEntity.ok(tests); }

}
