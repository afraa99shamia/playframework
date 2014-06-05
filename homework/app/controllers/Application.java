package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import views.html.*;
import  models.*;
import play.data.* ;
public class Application extends Controller {
  static Form<Task> taskForm = Form.form(Task.class);
static Task t ;
static List<Task> t1=new ArrayList<Task>();

    public static Result index() {
        return redirect(routes.Application.calc());
    }
   public static Result calc() {
     return ok(
    views.html.index.render(t1,taskForm)
  );
  }
 public static Result result() {
    Form<Task> filledForm = taskForm.bindFromRequest();
  if(filledForm.hasErrors()) {
    return badRequest(
      views.html.index.render(t1, filledForm)
    );
  } else {
   
   t=Task.create(filledForm.get());
    //return redirect(routes.Application.tasks()); 
    return ok(
    views.html.result.render(t)
  ); 
  }

   

  }
  
}
