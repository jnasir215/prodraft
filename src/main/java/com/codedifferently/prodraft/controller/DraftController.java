package com.codedifferently.prodraft.controller;

import com.codedifferently.prodraft.model.APIResponse;
import com.codedifferently.prodraft.model.Draft;
import com.codedifferently.prodraft.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DraftController {

    @Autowired
    private DraftService draftService;

    @GetMapping("/drafts")
    public ResponseEntity<List<Draft>> getAllDrafts() {
        return ResponseEntity.ok().body(draftService.getAllDrafts());
    }

    @GetMapping("/draft/{year}")
    public ResponseEntity<Draft> getDraftByYear(@PathVariable String year) {
        return ResponseEntity.ok().body(draftService.getDraftByYear(year));
    }

//    @PostMapping("/drafts")
//    public ResponseEntity<Draft> createDraft(@RequestBody Draft draft) {
//        return ResponseEntity.ok().body(this.draftService.createDraft(draft));
//    }

//    @PutMapping("/draft/{id}")
//    public ResponseEntity<Draft> updateDraft(@PathVariable String id, @RequestBody Draft draft) {
//        return ResponseEntity.ok().body(this.draftService.updateDraft(draft));
//    }

//    @GetMapping("/test/drafts")
//    public ResponseEntity<APIResponse> testDrafts() {
//        APIResponse apiResponse = draftService.restApiSample();
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
}
