package com.migrator;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

/**
 * Created by farhans on 02/09/16.
 */
public interface SolrDataReader {
    String readUser();

    SolrDocumentList streaming() throws SolrServerException, IOException, InterruptedException;
}
