package com.beans;

import com.enums.FieldType;
import com.enums.UserFields;
import com.utils.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by farhans on 03/09/16.
 */
public class Mapping {

   Map<String,Map<UserFields, Field>> mapping = new HashMap<String,Map<UserFields, Field>>();

    public Map<String, Map<UserFields, Field>> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String,Map<UserFields,Field>> mapping) {
        this.mapping = mapping;
    }

    public void setDefaultMapping(){

        Map<String,Map<UserFields, Field>> properties = new HashMap<String,Map<UserFields, Field>>();

        Map<UserFields, Field> fieldsMap = new HashMap<>();

        Field username = new Field();
        username.setType(FieldType.STRING.getType());
        username.setStore(true);
        fieldsMap.put(UserFields.username,username);

        Field id = new Field();
        id.setType(FieldType.LONG.getType());
        id.setStore(true);
        fieldsMap.put(UserFields.id,id);


        Field created = new Field();
        created.setStore(true);
        created.setType(FieldType.DATE.getType());
        fieldsMap.put(UserFields.created,created);

        Field email = new Field();
        email.setType(FieldType.STRING.getType());
        email.setStore(true);
        fieldsMap.put(UserFields.email,email);

        Field firstName = new Field();
        firstName.setType(FieldType.STRING.getType());
        firstName.setStore(true);
        fieldsMap.put(UserFields.first_name,firstName);

        Field lastName = new Field();
        lastName.setType(FieldType.STRING.getType());
        lastName.setStore(true);
        fieldsMap.put(UserFields.last_name,lastName);

        properties.put(Constants.TEXT_PROPERTIES,fieldsMap);
        this.mapping =properties;
    }
}
