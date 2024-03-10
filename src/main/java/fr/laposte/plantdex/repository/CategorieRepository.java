package fr.laposte.plantdex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.plantdex.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
