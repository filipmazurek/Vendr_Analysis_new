package controllers;

import java.sql.SQLException;

import java.sql.SQLException;
import java.util.Map;
import java.util.ArrayList;
import play.*;
import play.mvc.*;
import play.data.*;
import views.html.*;

import models.VendrDB;

public class Application extends Controller {

    public static Result index() throws SQLException {
            return ok(index.render(VendrDB.getAllUserNames()));
    }
}
