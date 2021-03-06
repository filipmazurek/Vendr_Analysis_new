package controllers;

import models.Merchant;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.customAnalytics;
import views.html.index;
import views.html.login;
import views.html.weeklyAnalytics;
import queries.QueryDB;

public class Application extends Controller {

    @Security.Authenticated(Secured.class)
    public static Result index() {
        return ok(index.render(
                Merchant.find.byId(request().username())
        ));
    }


    @Security.Authenticated(Secured.class)
    public static Result weeklyAnalytics() {
        return ok(weeklyAnalytics.render(
                Merchant.find.byId(request().username())
        ));
    }


    @Security.Authenticated(Secured.class)
    public static Result customAnalytics() {

        return ok(customAnalytics.render(
                Merchant.find.byId(request().username()),
                Form.form(Category.class)
        ));
    }

    @Security.Authenticated(Secured.class)
    public static Result getLikesByCategory() {

        Form<Category> categoryForm = Form.form(Category.class).bindFromRequest();

        String category = categoryForm.get().category.trim();


        System.out.println("it works with the following category = \"" + category + "\"");

        int likes = QueryDB.getNumLikesMerchantCategory(request().username(),category);

        flash("categoryLikes", Integer.toString(likes));

        System.out.println("and the likes it got = " + Integer.toString(likes));

        return redirect(routes.Application.customAnalytics());
    }


    public static Result login() {
        return ok(
                login.render(Form.form(Login.class))
        );
    }

    public static Result authenticate() {
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("merchant", loginForm.get().merchant);
            return redirect(
                    routes.Application.index()
            );
        }
    }

    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.Application.login()
        );
    }

    public static class Login {
        public String merchant;
        public String password;

        public String validate() {
            if (Merchant.authenticate(merchant, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }
    }

    public static class Category {
        public String category;
    }
}
