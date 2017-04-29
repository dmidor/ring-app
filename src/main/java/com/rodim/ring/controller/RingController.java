package com.rodim.ring.controller;

import com.rodim.ring.persistence.model.Ring;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//@RestController
//@RequestMapping("/api/ring")


@RepositoryRestResource(collectionResourceRel = "ring", path = "/api/ring")
public interface RingController extends PagingAndSortingRepository<Ring, String>
        //extends UserController
{
//
//    @Autowired
//    private RingService ringService;
//
//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public JsonNode getRing() {
//        List<Ring> all = ringService.getAll();
//        return getResponse(all);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void postRing(@RequestBody Ring ring) {
//        ringService.postRing(ring);
//    }
//
//    @RequestMapping(value = "/{ring-id}", method = RequestMethod.DELETE)
//    public void deleteRing(@PathVariable(value = "ring-id") String ringId) {
//        ringService.deleteRing(ringId);
//    }

}
