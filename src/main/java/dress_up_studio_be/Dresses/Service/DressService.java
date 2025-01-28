package dress_up_studio_be.Dresses.Service;

import dress_up_studio_be.Utils.DressUtils;
import dress_up_studio_be.Dresses.Models.DressDocument;
import dress_up_studio_be.Dresses.Models.DressModel;
import dress_up_studio_be.Dresses.Repository.DressRepository;
import dress_up_studio_be.Dresses.Enums.COLOR;
import dress_up_studio_be.Dresses.Enums.SIZE;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class DressService {

    @Autowired
    private DressRepository dressRepository;
    @Autowired
    ModelMapper modelMapper;

    private static final String UPLOAD_DIR = "uploads/";

    public List<DressModel> getAllDresses() {
        return dressRepository.findAll().stream()
                .map(dress -> modelMapper.map(dress, DressModel.class))
                .toList();
    }

    public DressModel saveDress(DressModel dressModel) {
        DressDocument dressDocument = modelMapper.map(dressModel, DressDocument.class);
        setDefaultFields(dressDocument);
        dressRepository.save(dressDocument);
        return modelMapper.map(dressDocument, DressModel.class);
    }

    public DressModel saveDressWithImage(MultipartFile file,
                                         String name,
                                         double price,
                                         List<SIZE> size,
                                         List<COLOR> color) {
        try {
            // 1. Zapisz plik na serwerze
            String imageUrl = UPLOAD_DIR + UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(imageUrl);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());


            // 3. Zapisz dane sukienki w bazie
            DressDocument dress = new DressDocument();
            dress.setName(name);
            dress.setPrice(price);
            dress.setSize(size);
            dress.setColor(color);
            dress.setImageUrl("/" + imageUrl);

            return modelMapper.map(dressRepository.save(dress), DressModel.class);

        } catch (IOException e) {
            throw new RuntimeException("Nie udało się zapisać pliku: " + e.getMessage(), e);
        }

    }

    public DressModel getDressByName(String name) {
        return modelMapper.map(dressRepository.findByName(name), DressModel.class);
    }

    public void deleteDress(String id) {
        dressRepository.deleteById(id);
    }

    private static void setDefaultFields(DressDocument dressDocument) {
        dressDocument.setAddedBy(DressUtils.getUserName());
        dressDocument.setModifiedBy(DressUtils.getUserName());
        dressDocument.setDateAdded(DressUtils.getCurrentSqlTime());
        dressDocument.setDateModified(DressUtils.getCurrentSqlTime());
    }
}
