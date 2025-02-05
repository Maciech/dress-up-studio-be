package dress_up_studio_be.Dresses.Controller;

import dress_up_studio_be.Dresses.Service.DressService;
import dress_up_studio_be.Dresses.Models.DressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/dresses")
public class DressController {

    @Autowired
    private DressService dressService;

    @GetMapping
    public List<DressModel> getAllDresses() {
        return dressService.getAllDresses();
    }
//
//    @PostMapping
//    public DressModel createDress(@RequestBody DressModel dress) {
//        return dressService.saveDress(dress);
//    }

    @GetMapping("/{name}")
    public DressModel getDressByName(@PathVariable String name) {
        return dressService.getDressByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteDress(@PathVariable Long id) {
        dressService.deleteDress(id);
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
