package com.example.demo.resource;

import com.example.demo.entity.Demo;
import com.example.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ashutoshpandey on 11/05/18.
 */
@RestController
@RequestMapping("/demo")
public class DemoResource {

    @Autowired
    private DemoService demoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Demo>> findAll(){
        return new ResponseEntity<Iterable<Demo>>(demoService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{externalId}", method = RequestMethod.GET)
    public ResponseEntity<Demo> find(@PathVariable("externalId") String externalId){
        return new ResponseEntity<Demo>(demoService.find(externalId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Demo> create(@RequestBody Demo demo){
        return new ResponseEntity<Demo>(demoService.create(demo), HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{externalId}", method = RequestMethod.PUT)
    public ResponseEntity<Demo> update(@PathVariable("externalId") String externalId, @RequestBody Demo demo){
        return new ResponseEntity<Demo>(demoService.update(externalId, demo), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{externalId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("externalId") String externalId){
        demoService.delete(externalId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
