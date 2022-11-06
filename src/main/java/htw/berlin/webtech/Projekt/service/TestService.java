package htw.berlin.webtech.Projekt.service;


import htw.berlin.webtech.Projekt.persistence.TestEntity;
import htw.berlin.webtech.Projekt.persistence.TestRepository;
import htw.berlin.webtech.Projekt.web.api.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    public List<Test> findAll() {
        List<TestEntity> tests = testRepository.findAll();
        return tests.stream()
                .map(testEntity -> new Test(
                        testEntity.getId(),
                        testEntity.getName(),
                        testEntity.getZubereitungsdauer(),
                        testEntity.isVegan(),
                        testEntity.getTageszeit())
                )
                .collect(Collectors.toList());
    }
}
