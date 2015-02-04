package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok("<h1>I'm index!!!</h1>");
    }

    public static Result show() {
        response().setContentType("text/html");
        response().setHeader(CACHE_CONTROL, "max-age=3600");
        response().setHeader(ETAG, "xxx");
        return ok("<h1>Hello World!</h1>");
    }

    public static Result tasks() {
        return TODO;
    }

    public static Result newTask() {
        return TODO;
    }

    public static Result deleteTask(Long id) {
        return TODO;
    }
}
