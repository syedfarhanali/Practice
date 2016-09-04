package com.service;

import com.beans.ElastiSearchCreateIndexRequest;
import com.beans.ElastiSearchDescribeDomainRequest;
import com.beans.Mapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by farhans on 01/09/16.
 */
@Component
public class AWSRequestServiceImpl extends RequestServiceImpl implements  AWSRequestService  {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> get(String url) throws IOException {
        try{
            return restTemplate.getForEntity(url,String.class);
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public ResponseEntity<String> getDomainInfo(List<String> domains) throws IOException {
        try{
            ElastiSearchDescribeDomainRequest edr = new ElastiSearchDescribeDomainRequest(domains);
            return restTemplate.postForEntity(getElastiSearchRestUrl(),edr,String.class);
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public void createIndex(String index) throws IOException {
        try{
            //String indexRequest = "{\"settings\" : {\"index\" : {\"number_of_shards\" : 1,\"number_of_replicas\" : 1}}}";
            ElastiSearchCreateIndexRequest request = new ElastiSearchCreateIndexRequest();
            restTemplate.put(getElasticSearchDomailUrl()+index,request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteIndex(String indexName){

        restTemplate.delete(getElasticSearchDomailUrl()+indexName);
    }

    @Override
    public void createMapping(String index,String mapping,Object mappingObj){
        try{
            //String mapText = "{\""+mapping+"\" : {\"properties\":{\"username\":{\"type\":\"string\",\"store\":true}}}}";
            restTemplate.put(getElasticSearchDomailUrl()+index+"/_mapping/"+ mapping , mappingObj);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addMapping(String index,String mappingname) throws IOException {
        try{
            String mappingRequest = "{\""+mappingname+"\" : {\"properties\" : {\"name\" : {\"type\" : \"string\", \"store\" : true }}}}";

            restTemplate.put(getElasticSearchDomailUrl()+index+"/_mapping/"+mappingname,mappingRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addFieldInMapping(String index, String mapping,String fieldName,String dataType) throws IOException {
        System.out.println(index+mapping+fieldName+dataType);
        try{
            String mappingRequest = "{\"properties\": {\""+fieldName+"\": {\"type\": \""+dataType+"\",\"store\": true}}}";
            restTemplate.put(getElasticSearchDomailUrl()+index+"/_mapping/"+mapping,mappingRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setData(String index, String mapping,Object object) throws IOException {
        try{
           // String dataRequest = "{\"name\" : \"farhan\",\"created\" : \"2009-11-15T14:12:12\"}";
            restTemplate.put(getElasticSearchDomailUrl()+index+"/"+mapping+"/1",object);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getData(String index, String mapping) throws IOException {
        try{
           // String dataRequest = "{\"name\" : \"farhan\",\"created\" : \"2009-11-15T14:12:12\"}";
            ResponseEntity<String> response = restTemplate.getForEntity(getElasticSearchDomailUrl()+index+"/"+mapping+"/1",String.class);
            System.out.println(response.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
