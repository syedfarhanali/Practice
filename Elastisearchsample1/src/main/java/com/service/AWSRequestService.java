package com.service;

import com.beans.Mapping;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by farhans on 01/09/16.
 */
public interface AWSRequestService {

    public ResponseEntity<String> get(String url) throws IOException;
    public ResponseEntity<String> getDomainInfo(List<String> domains) throws IOException;

    void createIndex(String index) throws IOException;

    void addMapping(String index,String mappingname) throws IOException;

    void addFieldInMapping(String index, String mapping,String fieldName,String dataType) throws IOException;

    void setData(String index, String mapping,Object object) throws IOException;

    void getData(String index, String mapping) throws IOException;

    void deleteIndex(String indexName);

    void createMapping(String index,String mapping,Object mappingObj);
}
