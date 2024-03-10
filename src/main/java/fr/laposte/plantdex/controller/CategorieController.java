package fr.laposte.plantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.repository.CategorieRepository;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
	
	@Autowired
    private CategorieRepository categorieRepository;

    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categorie getCategoryById(@PathVariable Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Categorie createCategory(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }

}
