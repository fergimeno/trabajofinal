/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import org.bson.Document;

/**
 *
 * @author fer
 */
public class Conexion {

    private static MongoClient client;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    public static MongoCollection<Document> getCollection() {
        return collection;
    }

    
    public static void open() {

        String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
        if (host == null) {
            client = new MongoClient();
            database = client.getDatabase("hardwell");
            collection = database.getCollection("tracks");
        } else {

            int port = Integer.parseInt(System.getenv("OPENSHIFT_MONGODB_DB_PORT"));
            //String dbname = System.getenv("OPENSHIFT_APP_NAME");
            String username = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
            String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
            
            MongoCredential credential = MongoCredential.createCredential(
                    username, "hardwell", password.toCharArray());
            
            MongoClient client = new MongoClient(
                    new ServerAddress(host, port),
                    Arrays.asList(credential)
            );
            
            client.setWriteConcern(WriteConcern.SAFE);
            database = client.getDatabase("hardwell");          
            
            collection = database.getCollection("tracks");
        }

    }

    public static void close() {
        if (client != null) {
            client.close();
        }
    }

}
