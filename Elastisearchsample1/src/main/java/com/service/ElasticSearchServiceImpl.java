package com.service;

import com.amazonaws.services.elasticsearch.AWSElasticsearch;
import com.amazonaws.services.elasticsearch.AWSElasticsearchAsyncClient;
import com.amazonaws.services.elasticsearch.model.DescribeElasticsearchDomainRequest;
import com.beans.Mapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.migrator.DataMigrationService;
import com.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by farhans on 01/09/16.
 */

@Component
public class ElasticSearchServiceImpl implements ElasticSearchService {

    @Autowired
    private AWSElasticsearchAsyncClient awsElasticsearchAsyncClient;

    @Autowired
    private AWSElasticsearch awsElasticsearch;

    @Autowired
    AWSRequestService awsRequestService;

    @Autowired
    Environment env;

    @Autowired
    DataMigrationService dataMigrationService;


    @Override
    public void createIndex(String index){
        try {
            awsRequestService.createIndex(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  void deleteIndex(String indexName){
        awsRequestService.deleteIndex(indexName);
    }

    @Override
    public void createUserMapping(){

        Map<String,Object> map = new HashMap<String,Object>();

        Mapping mapping = new Mapping();
        mapping.setDefaultMapping();

        map.put(Constants.MAPPING_DEFAULT,mapping.getMapping());
        awsRequestService.createMapping(Constants.INDEX_USER,Constants.MAPPING_DEFAULT,map);
    }

    @Override
    public void setData(String index,String mapping,Object object){
        try {
            awsRequestService.setData(index,mapping,object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    @Override
    public void testAWSElasticsearchClient(){
        String domainName = env.getProperty("elasticsearch.domain");
        DescribeElasticsearchDomainRequest dr = new DescribeElasticsearchDomainRequest();
        dr.setDomainName(domainName);
        //Future<DescribeElasticsearchDomainResult> describeElasticsearchDomainResultFuture = awsElasticsearchAsyncClient.describeElasticsearchDomainAsync(dr);

        try {
          //  DescribeElasticsearchDomainResult describeElasticsearchDomainResult = describeElasticsearchDomainResultFuture.get();
           // System.out.println(describeElasticsearchDomainResult.getDomainStatus());

            List<String> domains = new ArrayList<String>();
            domains.add(domainName);
           // System.out.println(awsRequestService.getDomainInfo(domains).toString());

            //awsRequestService.createIndex("fidelis");
            //awsRequestService.addMapping("fidelis");
            //awsRequestService.addFieldInMapping(Constants.INDEX_USER,Constants.MAPPING_USER,"created","Date");
            //awsRequestService.setData(Constants.INDEX_FIDELIS,Constants.MAPPING_USER);
            //awsRequestService.getData(Constants.INDEX_FIDELIS,Constants.MAPPING_USER);
            //dataMigrationService.migrateUsers();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
