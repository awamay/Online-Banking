package com.abc.onlinebanking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.abc.onlinebanking.domain.TransactionDetails;

public interface TransactionRepository extends CrudRepository<TransactionDetails, Long> {

//	List<TransactionDetails> findByAccountNumberEquals(String accountNumber);
	
}
