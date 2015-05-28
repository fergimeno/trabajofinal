package Aplicacion_Web;

import DAO.Track_DB;
import Entidad.Track;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.sun.xml.internal.ws.model.RuntimeModeler.PORT;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.*;
import static java.util.Arrays.asList;
import org.bson.Document;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerRoute;
import spark.ModelAndView;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        final Map<String, Object> data = new HashMap<>();

        final String IP_ADDRESS = System.getenv("OPENSHIFT_DIY_IP") != null ? System.getenv("OPENSHIFT_DIY_IP") : "localhost";
        final int PORT = System.getenv("OPENSHIFT_DIY_PORT") != null ? Integer.parseInt(System.getenv("OPENSHIFT_DIY_PORT")) : 4567;

        Spark.staticFileLocation(
                "/public");

        setIpAddress(IP_ADDRESS);

        setPort(PORT);

        get(
                new FreeMarkerRoute("/") {
                    @Override
                    public ModelAndView handle(Request request, Response response
                    ) {
                        data.put("tracks", Track_DB.listar());
                        return modelAndView(data, "listaUsuarios.ftl");
                    }
                }
        );

        post(
                new FreeMarkerRoute("track/create") {
                    @Override
                    public Object handle(Request request, Response response
                    ) {
                        Track t1 = new Track();
                        t1.setId(Track_DB.siguienteId());
                        t1.setNombre(request.queryParams("nombre"));
                        t1.setAutor(request.queryParams("autor"));
                        t1.setAlbum(request.queryParams("album"));
                        t1.setLink(request.queryParams("link"));
                        Track_DB.insertar(t1);
                        response.redirect("/form", 301);
                        return response;

                    }
                }
        );

        get(
                new FreeMarkerRoute("track/delete/:track_id") {
                    @Override
                    public Object handle(Request request, Response response
                    ) {
                        Track_DB.eliminar(Double.parseDouble(request.params("track_id")));

                        response.redirect("/", 301);
                        return response;
                    }
                }
        );

        post(
                new FreeMarkerRoute("edit/track/edit/:track_id") {
                    @Override
                    public Object handle(Request request, Response response
                    ) {
                        Track t1 = new Track();
                        t1.setId(Double.parseDouble(request.params("track_id")));
                        t1.setNombre(request.queryParams("nombre"));
                        t1.setAutor(request.queryParams("autor"));
                        t1.setAlbum(request.queryParams("album"));
                        t1.setLink(request.queryParams("link"));
                        Track_DB.editar(t1);

                        response.redirect("/", 301);
                        return response;
                    }
                }
        );

        get(
                new FreeMarkerRoute("/form") {
                    @Override
                    public ModelAndView handle(Request request, Response response
                    ) {
                        return modelAndView(null, "formulario.ftl");
                    }
                }
        );

        get(
                new FreeMarkerRoute("/edit/:track_id") {
                    @Override
                    public ModelAndView handle(Request request, Response response
                    ) {
                        data.put("track", Track_DB.buscar(Double.parseDouble(request.params("track_id"))));
                        return modelAndView(data, "edit.ftl");
                    }
                }
        );

    }
}
