package com.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by farhans on 01/09/16.
 */
public class ElastiSearchDescribeDomainRequest extends ElastiSearchRequest {

    private static final String DOMAIN_PARAM_NAME = "DomainNames";
    Map<String,List<String>> domainRequest;

    public ElastiSearchDescribeDomainRequest(){};

    public ElastiSearchDescribeDomainRequest(List<String> domains) {
        Map<String,List<String>> domainNamesMap = new HashMap<String,List<String>>();
        domainNamesMap.put(DOMAIN_PARAM_NAME,domains);
        domainRequest =domainNamesMap;
    }

    public void setDomainRequest(Map<String, List<String>> domainRequest) {
        this.domainRequest = domainRequest;
    }

    public Map<String, List<String>> getDomainRequest() {
        return domainRequest;
    }
}
