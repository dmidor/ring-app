package com.ring.persistence.repository;

import com.ring.persistence.model.Ring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RingRepository extends JpaRepository<Ring, String> {
    List<Ring> findAllByOwnerId(@Param("ownerId")String userId);
}
