package dress_up_studio_be.Dresses.Controller;

import dress_up_studio_be.Dresses.Service.DressService;
import dress_up_studio_be.Dresses.Models.DressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public DressModel createDress(@RequestBody DressModel dress) {
        return dressService.saveDress(dress);
    }

    @GetMapping("/{name}")
    public DressModel getDressByName(@PathVariable String name) {
        return dressService.getDressByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteDress(@PathVariable String id) {
        dressService.deleteDress(id);
    }
}
