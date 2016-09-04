package com.migrator;

import com.service.ElasticSearchService;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by farhans on 03/09/16.
 */
@Component
public class ElasticSearchWriterImpl implements  ElasticSearchWriter {

    @Autowired
    ElasticSearchService elasticSearchService;

    @Override
    public void write(String index,String mapping,SolrDocumentList list){
        list.forEach(item -> {
            elasticSearchService.setData(index,mapping,item);
        });
    }
}
