package com.codedifferently.prodraft.repository;

import com.codedifferently.prodraft.model.Draft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DraftRepository extends JpaRepository<Draft, String> {
}
