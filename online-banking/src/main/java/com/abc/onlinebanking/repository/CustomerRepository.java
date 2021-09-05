package com.abc.onlinebanking.repository;
import com.abc.onlinebanking.domain.CustomerDetails;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerDetails, String> {

}
