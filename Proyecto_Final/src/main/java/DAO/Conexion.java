/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
        client = new MongoClient();
        database = client.getDatabase("hardwell");
        collection = database.getCollection("tracks");
    }

    public static void close() {
        if (client != null) {
            client.close();
        }
    }

}
