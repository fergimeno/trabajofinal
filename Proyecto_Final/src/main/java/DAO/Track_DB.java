/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Track;
import com.mongodb.*;
import com.mongodb.client.*;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author fer
 */
public class Track_DB {

    public static ArrayList<Track> listar() {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("hardwell");
        MongoCollection<Document> collection = database.getCollection("tracks");

        ArrayList<Track> tracks = new ArrayList();

        MongoCursor<Document> cursor = collection.find().iterator();

        while (cursor.hasNext()) {
            tracks.add(jsonObject(cursor.next()));
        }
        client.close();
        return tracks;
    }

    public static void insertar(Track track) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("hardwell");
        MongoCollection<Document> collection = database.getCollection("tracks");

        collection.insertOne(objectJson(track));
        client.close();
    }

    public static double siguienteId() {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("hardwell");
        MongoCollection<Document> collection = database.getCollection("tracks");

        //db.tracks.find().sort({_id:-1}).limit(1);
        Bson sort = new Document("_id", -1);

        double id = collection.find().sort(sort).limit(1).getDouble("_id") + 1;

        return 
    }

    private static Track jsonObject(Document doc) {
        Track track1 = new Track();
        track1.setId((doc.getDouble("_id")));
        track1.setNombre(doc.getString("nombre"));
        track1.setAutor(doc.getString("autor"));
        track1.setAlbum(doc.getString("album"));
        track1.setDuracion(doc.getString("duracion"));
        return track1;
    }

    private static Document objectJson(Track track) {
        return new Document("_id", track.getId())
                .append("nombre", track.getNombre())
                .append("autor", track.getAutor())
                .append("album", track.getAlbum())
                .append("duracion", track.getDuracion());
    }

}
