package com.codedifferently.prodraft.service;

import com.codedifferently.prodraft.model.APIResponse;
import com.codedifferently.prodraft.model.Prospect;

import java.util.List;

public interface ProspectService {

    Prospect createProspect(Prospect prospect);

    Prospect updateProspect(Prospect prospect);

    List<Prospect> getAllProspects();

    Prospect getProspectById(String id);

    void deleteProspect(String id);

    APIResponse restApiSample(String year);
}
