package htw.berlin.webtech.Projekt.service;


import htw.berlin.webtech.Projekt.persistence.TestEntity;
import htw.berlin.webtech.Projekt.persistence.ITestRepository;
import htw.berlin.webtech.Projekt.web.api.Test;
import htw.berlin.webtech.Projekt.web.api.TestCreateOrUpdateRequest;
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
                .map(this::transformEntity)

                .collect(Collectors.toList());
    }

    public Test create(TestCreateOrUpdateRequest request){
        var testEntity= new TestEntity(request.getName(), request.getZubereitungsdauer(), request.isVegan(), request.getTageszeit());
        testEntity = testRepository.save(testEntity);
        return transformEntity(testEntity);
    }

    public Test update(Long id, TestCreateOrUpdateRequest request) {
        var testEntityOptional = testRepository.findById(id);
        if(testEntityOptional.isEmpty()) {
            return null;
        }

        var testEntity = testEntityOptional.get();
        testEntity.setName(request.getName());
        testEntity.setTageszeit(request.getTageszeit());
        testEntity.setVegan(request.isVegan());
        testEntity.setZubereitungsdauer(request.getZubereitungsdauer());
        testRepository.save(testEntity);

        return transformEntity(testEntity);
    }

    public boolean deleteById(Long id) {
        if (!testRepository.existsById(id)) {
            return false;
        }

        testRepository.deleteById(id);
        return true;
    }

    public Test findById(Long id) {
        var testEntity = testRepository.findById(id);
        return testEntity.map(this::transformEntity).orElse(null);
    }

    private Test transformEntity(TestEntity testEntity) {
        return new Test(
                testEntity.getId(),
                testEntity.getName(),
                testEntity.getZubereitungsdauer(),
                testEntity.isVegan(),
                testEntity.getTageszeit()

        );
    }
}
