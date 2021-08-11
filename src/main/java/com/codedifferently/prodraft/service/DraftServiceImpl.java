package com.codedifferently.prodraft.service;

import com.codedifferently.prodraft.model.APIResponse;
import com.codedifferently.prodraft.model.Draft;
import com.codedifferently.prodraft.repository.DraftRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DraftServiceImpl implements DraftService {

    private final static Log log = LogFactory.getLog(ProspectServiceImpl.class);
    private String userIdAndKeySuffix = "api_key=v768p8e2w5vg4a8dxfjprfeq";

    @Autowired
    private DraftRepository draftRepository;

    @Autowired
    private DraftServiceImpl draftService;

//    @Override
//    public Draft createDraft(Draft draft) {
//        return draftRepository.save(draft);
//    }

//    @Override
//    public Draft updateDraft(Draft draft) {
//        Optional<Draft> draftDb = this.draftRepository.findById(draft.getId());

//        if(draftDb.isPresent()) {
//            Draft draftUpdate = draftDb.get();
            // Do we want to change the auto-generated ID?
//            draftUpdate.setId(draft.getId());
//            draftUpdate.setYear(draft.getYear());
//            draftUpdate.setStatus(draft.getStatus());
//            draftRepository.save(draftUpdate);
//            return draftUpdate;
//        } else {
//            throw new ResourceNotFoundException("Record not found with id: " + draft.getId());
//        }
//    }

    @Override
    public List<Draft> getAllDrafts() {
        return this.draftRepository.findAll();
    }

    @Override
    public Draft getDraftByYear(String draftYear) {

        APIResponse apiResponse = draftService.restApiSample(draftYear);
        Draft draft = apiResponse.getDraft();
        // Need to capture "find by Year"
        //Optional<Draft> draftDb = this.draftRepository.findById(draftId);

        //if(draftDb.isPresent()) {
        //    return draftDb.get();
        //} else {
        //    throw new ResourceNotFoundException("Record not found with id: " + draftId);
        //}
        return draft;

    }

    @Override
    public APIResponse restApiSample(String year) {
        //String year = "2019", "2020" or "2021" only years available per API;
        RestTemplate restTemplate = new RestTemplate();
        //String url = "http://api.sportradar.us/draft/nba/trial/v1/en/2019/draft.json?api_key=v768p8e2w5vg4a8dxfjprfeq";
        String requestedUrl = "http://api.sportradar.us/draft/nba/trial/v1/en/" + year + "/draft.json?" + userIdAndKeySuffix;
        ResponseEntity<APIResponse> response = restTemplate.getForEntity(requestedUrl, APIResponse.class);
        APIResponse apiResponse = response.getBody();
        log.info(response);
        return apiResponse;
    }
}
