package com.beans;

/**
 * Created by farhans on 03/09/16.
 */
public class Index {

    private int number_of_shards=1;
    private int number_of_replicas=1;

    public int getNumber_of_replicas() {
        return number_of_replicas;
    }

    public int getNumber_of_shards() {
        return number_of_shards;
    }

    public void setNumber_of_replicas(int number_of_replicas) {
        this.number_of_replicas = number_of_replicas;
    }

    public void setNumber_of_shards(int number_of_shards) {
        this.number_of_shards = number_of_shards;
    }
}
