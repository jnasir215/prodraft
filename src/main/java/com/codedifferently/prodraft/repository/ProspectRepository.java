package com.codedifferently.prodraft.repository;

import com.codedifferently.prodraft.model.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProspectRepository extends JpaRepository<Prospect,String> {
}
