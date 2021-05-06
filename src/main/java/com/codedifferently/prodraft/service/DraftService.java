package com.codedifferently.prodraft.service;

import com.codedifferently.prodraft.model.APIResponse;
import com.codedifferently.prodraft.model.Draft;

import java.util.List;

public interface DraftService {

//    Draft createDraft(Draft draft);

//    Draft updateDraft(Draft draft);

    List<Draft> getAllDrafts();

    Draft getDraftByYear(String year);

    //void deleteDraft(String id);

    APIResponse restApiSample(String year);
}
