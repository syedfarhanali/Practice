package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by farhans on 01/09/16.
 */
@Component
public class RequestServiceImpl implements RequestService {

    @Value("${elasticsearch.domain.url}")
    protected String elasticSearchDomailUrl;

    @Value("${elasticsearch.api.path}")
    protected String elastiSearchApiPath;

    public String getElastiSearchRestUrl() {
        return elasticSearchDomailUrl +elastiSearchApiPath;
    }

    public String getElasticSearchDomailUrl() {
        return elasticSearchDomailUrl;
    }
}
