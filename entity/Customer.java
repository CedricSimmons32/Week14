package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.HashSet;


@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	// Many to Many relationship with pet_stores one customer can use many petStores
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	private Set<PetStore> petStores = new HashSet<>();
	
}
