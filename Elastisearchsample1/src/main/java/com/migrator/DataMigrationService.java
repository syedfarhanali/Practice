package com.migrator;


import org.springframework.beans.factory.annotation.Value;

/**
 * Created by farhans on 02/09/16.
 */
public interface DataMigrationService {

    boolean migrateUsers(String index,String mapping);
}
