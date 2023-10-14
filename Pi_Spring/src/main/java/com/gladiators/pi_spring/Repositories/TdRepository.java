package com.gladiators.pi_spring.Repositories;

import com.gladiators.pi_spring.Entities.TD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TdRepository extends JpaRepository<TD, Long> {
}
