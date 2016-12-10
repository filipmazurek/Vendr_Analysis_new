package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Application extends Controller {

  @Security.Authenticated(Secured.class)
  public static Result index() {
    return ok(index.render(
    Merchant.find.byId(request().username())
    ));
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
}
