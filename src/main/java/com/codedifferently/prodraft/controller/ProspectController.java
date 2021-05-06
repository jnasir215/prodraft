package com.codedifferently.prodraft.controller;

import com.codedifferently.prodraft.model.APIResponse;
import com.codedifferently.prodraft.model.Prospect;
import com.codedifferently.prodraft.service.ProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProspectController {

    @Autowired
    private ProspectService prospectService;

    @GetMapping("/prospects")
    public ResponseEntity<List<Prospect>> getAllProspects() {
        return ResponseEntity.ok().body(prospectService.getAllProspects());
    }

    @GetMapping("/prospect/{id}")
    public ResponseEntity<Prospect> getProspectById(@PathVariable String id) {
        return ResponseEntity.ok().body(prospectService.getProspectById(id));
    }

    //@PostMapping("/prospects")
    @RequestMapping(value = "/prospects", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Prospect> createProspect(@RequestBody Prospect prospect) {
        return ResponseEntity.ok().body(this.prospectService.createProspect(prospect));
    }

    @PutMapping("/prospect/{id}")
    public ResponseEntity<Prospect> updateProspect(@PathVariable String id, @RequestBody Prospect prospect) {
        return ResponseEntity.ok().body(this.prospectService.updateProspect(prospect));
    }

    @DeleteMapping("/prospects/{id}")
    public HttpStatus deleteProspect(@PathVariable String id) {
        this.prospectService.deleteProspect(id);
        return HttpStatus.OK;
    }

    @GetMapping("/test/prospects/{year}")
    public ResponseEntity<APIResponse> testProspects(@PathVariable String year) {
        APIResponse apiResponse = prospectService.restApiSample(year);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
