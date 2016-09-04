package com.migrator;

import org.apache.solr.client.solrj.StreamingResponseCallback;
import org.apache.solr.common.SolrDocument;

/**
 * Created by farhans on 02/09/16.
 */
public class SolrStreamCalbackHandler extends StreamingResponseCallback {

    @Override
    public void streamSolrDocument(SolrDocument solrDocument) {
        System.out.println(solrDocument.getFieldValue("id"));
    }

    @Override
    public void streamDocListInfo(long l, long l1, Float aFloat) {

    }
}
