package com.migrator;

import org.apache.solr.common.SolrDocumentList;

/**
 * Created by farhans on 03/09/16.
 */
public interface ElasticSearchWriter {

    public void write( String index,String mapping,SolrDocumentList list);
}
