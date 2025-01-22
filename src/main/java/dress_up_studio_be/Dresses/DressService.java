package dress_up_studio_be.Dresses;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressService {

    @Autowired
    private DressRepository dressRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<DressModel> getAllDresses() {
        return dressRepository.findAll().stream()
                .map(dress -> modelMapper.map(dress, DressModel.class))
                .toList();
    }

    public DressModel saveDress(DressModel dressModel) {
        DressDocument dressDocument = modelMapper.map(dressModel, DressDocument.class);
        dressDocument.setAddedBy(DressUtils.getUserName());
        dressDocument.setModifiedBy(DressUtils.getUserName());
        dressDocument.setDateAdded(DressUtils.getCurrentSqlTime());
        dressDocument.setDateModified(DressUtils.getCurrentSqlTime());
        dressRepository.save(dressDocument);
        return modelMapper.map(dressDocument, DressModel.class);
    }

    public DressModel getDressByName(String name) {
        return modelMapper.map(dressRepository.findByName(name), DressModel.class);
    }

    public void deleteDress(String id) {
        dressRepository.deleteById(id);
    }
}
