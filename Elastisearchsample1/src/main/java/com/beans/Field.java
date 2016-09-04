package com.beans;

import com.enums.IndexType;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by farhans on 04/09/16.
 */
public class Field {

    private String type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private IndexType index;

    private boolean store;

    public void setType(String type) {
        this.type=type;
    }

    public void setIndex(IndexType index) {
        this.index = index;
    }

    public boolean isStore() {
        return store;
    }

    public String getType() {
        return type;
    }

    public IndexType getIndex() {
        return index;
    }

    public void setStore(boolean store) {
        this.store = store;
    }


}
