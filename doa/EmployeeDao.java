package pet.store.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
