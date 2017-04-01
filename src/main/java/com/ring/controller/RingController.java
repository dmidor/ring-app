package com.ring.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.ring.persistence.model.Ring;
import com.ring.service.RingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ring")
public class RingController extends UserController {

    @Autowired
    private RingService ringService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonNode getRing() {
        List<Ring> all = ringService.getAll();
        return getResponse(all);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postRing(@RequestBody Ring ring) {
        ringService.postRing(ring);
    }

    @RequestMapping(value = "/{ring-id}", method = RequestMethod.DELETE)
    public void deleteRing(@PathVariable(value = "ring-id") String ringId) {
        ringService.deleteRing(ringId);
    }

}
