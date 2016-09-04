package com.migrator;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by farhans on 02/09/16.
 */
@Component
public class SolrDataReaderImpl implements SolrDataReader {

    @Value("${solr.url}")
    private String solrUrl;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public String readUser(){
        ResponseEntity<String> response =  restTemplate.getForEntity(getSolrUserFetchUrl(),null,String.class);
        System.out.println(response.toString());
        return response.toString();

    }

    private String getSolrUserFetchUrl(){
        return "http://localhost:8080/solr/users/select?q=*%3A*&wt=json&indent=true";
    }

    @Override
    public SolrDocumentList streaming() throws SolrServerException, IOException, InterruptedException {
        HttpSolrServer server = new HttpSolrServer(solrUrl+"/users");

        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q", "*:*");
        QueryResponse queryResponse = server.query(params);
        SolrDocumentList list = queryResponse.getResults();

        System.out.println(list.size());
        return list;
     /*   SolrQuery tmpQuery = new SolrQuery();
        tmpQuery.setRows(Integer.MAX_VALUE);
        final BlockingQueue<SolrDocument> tmpQueue = new LinkedBlockingQueue<SolrDocument>();
        server.queryAndStreamResponse(tmpQuery, new SolrStreamCalbackHandler());*/
    }


}
