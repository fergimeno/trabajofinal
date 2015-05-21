package daw.ed.proyect_fgimeno;

import spark.Request;
import spark.Response;
import spark.Route;
import java.util.*;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerRoute;
import spark.ModelAndView;
import spark.Spark;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
            Spark.staticFileLocation("/public");

        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {

                return modelAndView(null, "listaUsuarios.ftl");
            }
        });
    
    }
}
