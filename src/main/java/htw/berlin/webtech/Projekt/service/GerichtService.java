package htw.berlin.webtech.Projekt.service;


import htw.berlin.webtech.Projekt.persistence.GerichtEntity;
import htw.berlin.webtech.Projekt.persistence.IGerichtRepository;
import htw.berlin.webtech.Projekt.web.api.Gericht;
import htw.berlin.webtech.Projekt.web.api.GerichtCreateOrUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GerichtService {

    @Autowired
    IGerichtRepository gerichtRepository;


    public List<Gericht> findAll() {
        List<GerichtEntity> gerichte = gerichtRepository.findAll();
        return gerichte.stream()
                .map(this::transformEntity)

                .collect(Collectors.toList());
    }

    public GerichtEntity save(GerichtEntity gerichtEntity) {
        return gerichtRepository.save(gerichtEntity);
    }

    public Gericht create(GerichtCreateOrUpdateRequest request){
        var gerichtEntity= new GerichtEntity(request.getName(), request.getZubereitungsdauer(), request.isVegan(), request.getTageszeit()
//                request.getCounter()
        );
        gerichtEntity = gerichtRepository.save(gerichtEntity);
        return transformEntity(gerichtEntity);
    }

    public Gericht update(Long id, GerichtCreateOrUpdateRequest request) {
        var gerichtEntityOptional = gerichtRepository.findById(id);
        if(gerichtEntityOptional.isEmpty()) {
            return null;
        }

        var gerichtEntity = gerichtEntityOptional.get();
        gerichtEntity.setName(request.getName());
        gerichtEntity.setTageszeit(request.getTageszeit());
        gerichtEntity.setVegan(request.isVegan());
        gerichtEntity.setZubereitungsdauer(request.getZubereitungsdauer());
//        gerichtEntity.setCounter(request.getCounter());
        gerichtRepository.save(gerichtEntity);

        return transformEntity(gerichtEntity);
    }

    public boolean deleteById(Long id) {
        if (!gerichtRepository.existsById(id)) {
            return false;
        }

        gerichtRepository.deleteById(id);
        return true;
    }

    public Gericht findById(Long id) {
        var gerichtEntity = gerichtRepository.findById(id);
        return gerichtEntity.map(this::transformEntity).orElse(null);
    }

    public List<Gericht> findByName(String name) {
        var gerichtEntity = gerichtRepository.findAllByName(name);
        return gerichtEntity.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    private Gericht transformEntity(GerichtEntity gerichtEntity) {
        return new Gericht(
                gerichtEntity.getId(),
                gerichtEntity.getName(),
                gerichtEntity.getZubereitungsdauer(),
                gerichtEntity.isVegan(),
                gerichtEntity.getTageszeit()
//                gerichtEntity.getCounter()

        );
    }
}
