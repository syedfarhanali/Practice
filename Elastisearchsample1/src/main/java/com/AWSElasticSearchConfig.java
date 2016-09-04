package com;

import com.amazonaws.auth.*;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.cloudsearchv2.AmazonCloudSearchClient;
import com.amazonaws.services.elasticsearch.*;
import com.amazonaws.services.iot.AWSIot;
import com.amazonaws.services.iot.model.ElasticsearchAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static com.amazonaws.auth.policy.Principal.WebIdentityProviders.Amazon;

/**
 * Created by farhans on 01/09/16.
 */
@Configuration
public class AWSElasticSearchConfig {

    @Autowired
    private Environment env;

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider(){
        return new ProfileCredentialsProvider("default");
    }

    @Bean
    public AWSElasticsearchAsyncClient awsElasticsearchAsyncClient(AWSCredentialsProvider awsCredentialsProvider){
        AWSElasticsearchAsyncClient awsElasticsearchAsyncClient = new AWSElasticsearchAsyncClient(awsCredentialsProvider);
        awsElasticsearchAsyncClient.setEndpoint(env.getProperty("elasticsearch.domain"));
        Region region = RegionUtils.getRegion(env.getProperty("kinesis.regionName"));
        awsElasticsearchAsyncClient.setRegion(region);


        return awsElasticsearchAsyncClient;
    }
}
