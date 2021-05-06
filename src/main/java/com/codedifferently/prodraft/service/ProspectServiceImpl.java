package com.codedifferently.prodraft.service;

import com.codedifferently.prodraft.controller.ResourceNotFoundException;
import com.codedifferently.prodraft.model.APIResponse;
import com.codedifferently.prodraft.model.Prospect;
import com.codedifferently.prodraft.repository.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Optional;

@Service
public class ProspectServiceImpl implements ProspectService {

    private static  Log log = LogFactory.getLog(ProspectServiceImpl.class);
    private String userIdAndKeySuffix = "api_key=v768p8e2w5vg4a8dxfjprfeq";


    @Autowired
    private ProspectRepository prospectRepository;

    @Override
    public Prospect createProspect(Prospect prospect) {
        return prospectRepository.save(prospect);
    }

    @Override
    public Prospect updateProspect(Prospect prospect) {
        // Do we want to query the name of the Prospect rather than the ID?
        Optional<Prospect> prospectDb = this.prospectRepository.findById(prospect.getId());

        if(prospectDb.isPresent()) {
            Prospect prospectUpdate = prospectDb.get();
            // Do we want to change the auto-generated ID?
            prospectUpdate.setId(prospect.getId());
            prospectUpdate.setName(prospect.getName());
            prospectUpdate.setPosition(prospect.getPosition());
            prospectRepository.save(prospectUpdate);
            return prospectUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + prospect.getId());
        }
    }

    @Override
    public List<Prospect> getAllProspects() {
        return this.prospectRepository.findAll();
    }

    @Override
    public Prospect getProspectById(String prospectId) {
        Optional<Prospect> prospectDb = this.prospectRepository.findById(prospectId);

        if(prospectDb.isPresent()) {
            return prospectDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + prospectId);
        }
    }

    @Override
    public void deleteProspect(String prospectId) {
        // Do we want to query the name of the Invention rather than the ID?
        Optional<Prospect> prospectDb = this.prospectRepository.findById(prospectId);

        if(prospectDb.isPresent()) {
            this.prospectRepository.delete(prospectDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + prospectId);
        }
    }

    @Override
    public APIResponse restApiSample(String year) {
        //String year = "2019" or "2020" only years available per API;
        RestTemplate restTemplate = new RestTemplate();
        //String url = "http://api.sportradar.us/draft/nba/trial/v1/en/2019/draft.json?api_key=v768p8e2w5vg4a8dxfjprfeq";
        String requestedUrl = "http://api.sportradar.us/draft/nba/trial/v1/en/" + year + "/draft.json?" + userIdAndKeySuffix;
        ResponseEntity<APIResponse> response = restTemplate.getForEntity(requestedUrl, APIResponse.class);
        APIResponse apiResponse = response.getBody();
        log.info(response);
        return apiResponse;
    }
}
