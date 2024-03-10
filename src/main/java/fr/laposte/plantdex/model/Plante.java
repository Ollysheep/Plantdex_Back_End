package fr.laposte.plantdex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Plante {
	
	private String nom;
	private int arrosage;
	private String imageUrl;
	
	@Enumerated(EnumType.STRING)
	private Ensoleillement ensoleillement;
	
	@ManyToOne
    @JoinColumn(name = "categorie_id")
	private Categorie categorie;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
