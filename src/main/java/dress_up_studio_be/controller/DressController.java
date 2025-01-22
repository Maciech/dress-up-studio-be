package dress_up_studio_be.controller;

import dress_up_studio_be.model.Dress;
import dress_up_studio_be.service.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dresses")
public class DressController {

    @Autowired
    private DressService dressService;

    @GetMapping
    public List<Dress> getAllDresses() {
        return dressService.getAllDresses();
    }

    @PostMapping
    public Dress createDress(@RequestBody Dress dress) {
        return dressService.saveDress(dress);
    }

    @GetMapping("/{name}")
    public Dress getDressByName(@PathVariable String name) {
        return dressService.getDressByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteDress(@PathVariable String id) {
        dressService.deleteDress(id);
    }
}
