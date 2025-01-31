package dress_up_studio_be.FileManagement;

import dress_up_studio_be.Dresses.Models.DressAvailability;
import dress_up_studio_be.Dresses.Models.DressModel;
import dress_up_studio_be.Dresses.Service.DressService;
import dress_up_studio_be.Dresses.Enums.COLOR;
import dress_up_studio_be.Dresses.Enums.SIZE;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/fileManagement")
public class FileManagementController {

    @Autowired
    private DressService dressService;


    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DressModel> uploadFile(@RequestParam("files") List<MultipartFile> file,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("productCode") String productCode,
                                                 @RequestParam("price") double price,
                                                 @RequestPart("dressAvailability") List<DressAvailability> dressAvailability,
                                                 @RequestParam("color") COLOR color) {
        return ResponseEntity.ok().body(dressService.saveDressWithImage(file, name, price, dressAvailability, productCode, color));
    }

    @PostMapping(path = "/saveImages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<String>> saveImages(@RequestParam("files") List<MultipartFile> file) {
        return ResponseEntity.ok().body(dressService.saveImagesInUploads(file));
    }

    @PostMapping(path = "/saveDress")
    public ResponseEntity<DressModel> saveDress(@RequestBody DressModel dressModel) {
        return ResponseEntity.ok().body(dressService.saveDressAfterImages(dressModel));
    }
}