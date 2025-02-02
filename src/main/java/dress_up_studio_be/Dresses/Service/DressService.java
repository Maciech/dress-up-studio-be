package dress_up_studio_be.Dresses.Service;

import dress_up_studio_be.Dresses.Enums.COLOR;
import dress_up_studio_be.Dresses.Models.DressAvailability;
import dress_up_studio_be.Dresses.Models.DressModel;
import dress_up_studio_be.Dresses.Models.DressMstEntity;
import dress_up_studio_be.Dresses.Repository.DressRepository;
import dress_up_studio_be.Utils.DressUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        DressMstEntity dressMstEntity = modelMapper.map(dressModel, DressMstEntity.class);
        setDefaultFields(dressMstEntity);
        dressRepository.save(dressMstEntity);
        return modelMapper.map(dressMstEntity, DressModel.class);
    }

    public DressModel saveDressWithImage(List<MultipartFile> files,
                                         String name,
                                         double price,
                                         List<DressAvailability> dressAvailability,
                                         String productCode,
                                         COLOR color) {

        List<String> imageUrls = storeUrls(files);

        DressMstEntity dress = new DressMstEntity();
        dress.setProductCode(productCode);
        dress.setName(name);
        dress.setDressAvailability(dressAvailability);
        dress.setColor(color);
        dress.setImageUrls(imageUrls);
        setDefaultFields(dress);

        return modelMapper.map(dressRepository.save(dress), DressModel.class);
    }

    public List<String> saveImagesInUploads(List<MultipartFile> files) {
        return storeUrls(files);
    }

    public DressModel saveDressAfterImages(DressModel dressModel) {
        DressMstEntity dress = new DressMstEntity();
        dress.setProductCode(dressModel.getProductCode());
        dress.setName(dressModel.getName());

        List<DressAvailability> dressAvailabilities = getDressAvailabilities(dressModel);
        dress.setDressAvailability(dressAvailabilities);
        dress.setColor(dressModel.getColor());
        dress.setImageUrls(dressModel.getImageUrls());
        setDefaultFields(dress);

        for (DressAvailability availability : dressAvailabilities) {
            availability.setDressMstEntity(dress);
        }

        return modelMapper.map(dressRepository.save(dress), DressModel.class);
    }

    private static List<DressAvailability> getDressAvailabilities(DressModel dressModel) {
        List<DressAvailability> dressAvailabilities = new ArrayList<>();

        dressModel.getDressAvailability().forEach(model -> {
            dressAvailabilities.add(DressAvailability.builder()
                    .size(model.getSize())
                    .price(model.getPrice())
                    .isAvailable(model.getIsAvailable())
                    .build());
        });
        return dressAvailabilities;
    }


    public DressModel getDressByName(String name) {
        return modelMapper.map(dressRepository.findByName(name), DressModel.class);
    }

    public void deleteDress(Long id) {
        dressRepository.deleteById(id);
    }

    private List<String> storeUrls(List<MultipartFile> files) {
        List<String> imageUrls = new ArrayList<>();
        files.forEach(multipartFile -> {
                    try {
                        String imageUrl = UPLOAD_DIR + UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
                        Path filePath = Paths.get(imageUrl);
                        Files.createDirectories(filePath.getParent());
                        Files.write(filePath, multipartFile.getBytes());
                        imageUrls.add("/" + imageUrl);
                    } catch (IOException e) {
                        throw new RuntimeException("Nie udało się zapisać pliku: " + e.getMessage(), e);
                    }
                }
        );
        return imageUrls;
    }

    private static void setDefaultFields(DressMstEntity dressMstEntity) {
        dressMstEntity.setAddedBy(DressUtils.getUserName());
        dressMstEntity.setModifiedBy(DressUtils.getUserName());
        dressMstEntity.setDateAdded(DressUtils.getCurrentSqlTime());
        dressMstEntity.setDateModified(DressUtils.getCurrentSqlTime());
    }
}
