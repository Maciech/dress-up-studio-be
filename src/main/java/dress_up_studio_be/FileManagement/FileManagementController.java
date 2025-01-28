package dress_up_studio_be.FileManagement;

import dress_up_studio_be.Dresses.Models.DressModel;
import dress_up_studio_be.Dresses.Service.DressService;
import dress_up_studio_be.Dresses.Enums.COLOR;
import dress_up_studio_be.Dresses.Enums.SIZE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/fileManagement")
public class FileManagementController {

    @Autowired
    private DressService dressService;
    private static final String UPLOAD_DIR = "/uploads/";

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DressModel> uploadFile(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("price") double price,
                                                 @RequestParam("size") List<SIZE> size,
                                                 @RequestParam("color")List<COLOR> color) {
        return ResponseEntity.ok().body(dressService.saveDressWithImage(file, name, price, size, color));
    }
}