package dress_up_studio_be.service;

import dress_up_studio_be.model.Dress;
import dress_up_studio_be.repository.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressService {

    @Autowired
    private DressRepository dressRepository;

    public List<Dress> getAllDresses() {
        return dressRepository.findAll();
    }

    public Dress saveDress(Dress dress) {
        return dressRepository.save(dress);
    }

    public Dress getDressByName(String name) {
        return dressRepository.findByName(name);
    }

    public void deleteDress(String id) {
        dressRepository.deleteById(id);
    }
}
