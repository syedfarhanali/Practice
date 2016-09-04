package com.enums;

/**
 * Created by farhans on 04/09/16.
 */
public enum IndexType {
    ANALYZED("analyzed"),
    NOT_ANALYZED("not_analyzed"),
    NO("no");

    private String indexType;



    IndexType(String indexType) {
        this.indexType=indexType;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }
}
