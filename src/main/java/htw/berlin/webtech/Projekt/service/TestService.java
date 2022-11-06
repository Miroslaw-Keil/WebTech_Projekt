package htw.berlin.webtech.Projekt.service;


import htw.berlin.webtech.Projekt.persistence.TestEntity;
import htw.berlin.webtech.Projekt.persistence.ITestRepository;
import htw.berlin.webtech.Projekt.web.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService {

    @Autowired
    ITestRepository testRepository;

/*    public TestService(ITestRepository testRepository) {
        this.testRepository = testRepository;
    }
*/

    public List<Test> findAll() {
        List<TestEntity> tests = testRepository.findAll();
        return tests.stream()
                .map(this::tranformEntity)

                .collect(Collectors.toList());
    }


    private Test tranformEntity(TestEntity testEntity) {
        return new Test(
                testEntity.getId(),
                testEntity.getName(),
                testEntity.getZubereitungsdauer(),
                testEntity.isVegan(),
                testEntity.getTageszeit()

        );
    }
}
