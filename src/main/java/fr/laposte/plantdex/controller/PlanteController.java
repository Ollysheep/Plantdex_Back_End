package fr.laposte.plantdex.controller;

import fr.laposte.plantdex.model.Categorie;
import fr.laposte.plantdex.model.Plante;
import fr.laposte.plantdex.repository.CategorieRepository;
import fr.laposte.plantdex.repository.PlanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/plante")
public class PlanteController {

    @Autowired
    private PlanteRepository planteRepository;

    @Autowired
    private CategorieRepository categorieRepository; // Correction de cas ici

    @GetMapping
    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Plante getPlanteById(@PathVariable Long id) {
        return planteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Plante createPlante(@RequestBody Plante plante) {
        return planteRepository.save(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable Long id) {
        planteRepository.deleteById(id);
    }

    @GetMapping("/byCategorie")
    public List<Plante> getPlantesByCategorie(@RequestParam Long categorieId) {
        return planteRepository.findByCategorieId(categorieId);
    }

    @PostMapping("/byCategorie")
    public Plante createPlanteWithCategorie(@RequestBody Plante plante, @RequestParam Long categorieId) {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new NoSuchElementException("Categorie not found with id: " + categorieId));

        plante.setCategorie(categorie);

        return planteRepository.save(plante);
    }
}
