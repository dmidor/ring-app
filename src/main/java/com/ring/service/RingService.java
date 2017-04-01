package com.ring.service;

import com.ring.persistence.model.Ring;
import com.ring.persistence.repository.RingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RingService {

    @Autowired
    private RingRepository ringRepository;

    public List<Ring> getAll() {
        return ringRepository.findAll();
    }

    public void postRing(Ring ring) {
        ringRepository.save(ring);
    }

    public void deleteRing(String ringId) {
        ringRepository.delete(ringId);
    }
}
