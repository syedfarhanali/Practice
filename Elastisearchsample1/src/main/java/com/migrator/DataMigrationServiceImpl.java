package com.migrator;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by farhans on 02/09/16.
 */
@Component
public class DataMigrationServiceImpl implements DataMigrationService {

    @Autowired
    private SolrDataReader solrDataReader;

    @Autowired
    ElasticSearchWriter elasticSearchWriter;

    @Override
    public boolean migrateUsers(String index,String mapping){

        try {
            SolrDocumentList list = solrDataReader.streaming();
            elasticSearchWriter.write(index,mapping,list);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Boolean.TRUE;
    }


}
