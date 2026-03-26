package com.InsuranceApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.InsuranceApplication.DTO.Client;

@Component
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
