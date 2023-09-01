package pet.store.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;





@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	
	@Autowired
	private PetStoreService petStoreService;
	
	
	
	 	@Param
	 	@return
	
			
	@PostMapping("/pet_store")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData creatPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Create the pet store ()", petStoreData);
		
		return petStoreService.savePetStore(petStoreData);
	}

	 
	 	@Param
	 	@Param
	 	
	
	@PutMapping("/{petStoreId}")
	public PetStoreData updatePetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
		
		petStoreData.setPetStoreId(petStoreId);
		log.info("Updating pet store ()", petStoreData);
		
		return petStoreService.savePetStore(petStoreData);
	}
	
	
	@PostMapping("/{petStoreId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee insertEmployee (@PathVariable long petStoreId, @RequestBody PetStoreEmployee petStoreEmployee) {
		log.info("Creating employee () for pet store with ID=()", petStoreEmployee.getEmployeeId(), petStoreId);
		
		return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
	}
	
	
	
	@PostMapping("/{petStoreId}/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee insertCustomer (@PathVariable long petStoreId, 
			@RequestBody  PetStoreCustomer petStoreCustomer) {
		log.info("creating customer () for pet store with ID=()", petStoreCustomer.getCustomerId().petStoreId);
		
		return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
		
	}
	
	
	@GetMapping("/pet_store")
	public List<PetStoreData> listAllPetStore() {
		log.info("list all pet stores.");
		return petStoreService.retrieveAllPetStores();
	}
	
	@GetMapping("/pet_store/{petStoreId}")
	public PetStoreData getPetStoreById(@PathVariable long petStoreId) {
		log.info("Retrieving pet store with ID=()", petStoreId);
		return petStoreService.retrievePetStoreById(petStoreId);
	}
	
	@DeleteMapping("/{petStoreId}")
	
}

