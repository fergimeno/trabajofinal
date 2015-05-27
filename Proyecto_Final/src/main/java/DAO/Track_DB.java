/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Track;
import com.mongodb.*;
import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author fer
 */
public class Track_DB {

    public static ArrayList<Track> listar() {
        Conexion.open();
        ArrayList<Track> tracks = new ArrayList();

        MongoCursor<Document> cursor = Conexion.getCollection().find().iterator();

        while (cursor.hasNext()) {
            tracks.add(jsonObject(cursor.next()));
        }

        Conexion.close();
        return tracks;
    }

    public static void insertar(Track track) {
        Conexion.open();

        Conexion.getCollection().insertOne(objectJson(track));
        Conexion.close();
    }

    public static double siguienteId() {
        Conexion.open();

        //db.tracks.find().sort({_id:-1}).limit(1);
        Bson sort = new Document("_id", -1);
        double id;
        try {
            id = Conexion.getCollection().find().sort(sort).first().getDouble("_id") + 1;
        } catch (NullPointerException e) {
            id = 0;
        }

        Conexion.close();

        return id;
    }

    public static void eliminar(double id) {
        Conexion.open();

        Conexion.getCollection().deleteOne(new Document("_id", id));

        Conexion.close();
    }

    public static Track buscar(double id) {
        Conexion.open();
        Bson filter = new Document("_id", id);

        Track t = jsonObject(Conexion.getCollection().find(filter).first());
        Conexion.close();

        return t;
    }

    public static void editar(Track track) {
        Conexion.open();

        Conexion.getCollection().replaceOne(eq("_id", track.getId()), objectJson(track));
        Conexion.close();
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
