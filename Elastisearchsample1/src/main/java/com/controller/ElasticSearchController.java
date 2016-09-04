package com.controller;

import com.migrator.DataMigrationService;
import com.service.ElasticSearchService;
import com.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by farhans on 03/09/16.
 */
@RestController
@RequestMapping("/es")
public class ElasticSearchController {

    @Autowired
    private DataMigrationService dataMigrationService;

    @Autowired
    ElasticSearchService elasticSearchService;

    @RequestMapping(value = "/createIndex/{indexName}")
    public void createIndex(@PathVariable String indexName){

        elasticSearchService.createIndex(indexName);
    }

    @RequestMapping(value = "/deleteIndex/{indexName}")
    public void deleteIndex(@PathVariable String indexName){

        elasticSearchService.deleteIndex(indexName);
    }

    @RequestMapping(value = "/createMapping")
    public void createMapping(){
        elasticSearchService.createUserMapping();
    }

    @RequestMapping(value = "/migrate/user")
    public void migrate(){

        dataMigrationService.migrateUsers(Constants.INDEX_USER,Constants.MAPPING_DEFAULT);
    }


}
