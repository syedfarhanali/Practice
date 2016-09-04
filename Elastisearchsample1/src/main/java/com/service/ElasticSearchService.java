package com.service;

/**
 * Created by farhans on 01/09/16.
 */
public interface ElasticSearchService {
    void createIndex(String index);

    void setData(String index,String mapping,Object object);

    void testAWSElasticsearchClient();

    void deleteIndex(String indexName);

    void createUserMapping();
}
