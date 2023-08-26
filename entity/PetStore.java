package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.Set;
import java.util.HashSet;




@Entity
@Data
public class PetStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petStoreId;
	
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private Long petStoreZip;
	private String petStorePhone;
	
	// Many to Many relationship with customer. Join tables. 
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet _store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private Set <Customer> customers = new HashSet<>();
	
	//One to Many relationship with employee table. One petStore has multiple employees
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Employee> employees = new HashSet<>();
	

}
