package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import java.util.HashMap

@Singleton
class TodoController @Inject()(val controllerComponents: ControllerComponents) extends BaseController with Todo{
    def addTodo(text: String) = Action { implicit request: Request[AnyContent] => 
        val res = add(text)
        Ok(s"id: $res")
    }
    def a() = Action { implicit request: Request[AnyContent] => 
        val a = request.headers.get("Cookie")
        Ok(s"$a")
    }

    def getTodo(id: Int) = Action { implicit request: Request[AnyContent] => 
        val res = get(id)
        Ok(res)
    }

    def deleteTodo(id: Int) = Action { implicit request: Request[AnyContent] => 
        val res = delete(id)
        Ok(res)
    }
}


trait Todo {
    var counter: Int = 0
    var pool: HashMap[Int, String] = new HashMap()

    def get(id: Int): String = {
        pool.get(id)
    }

    def add(text: String):  Int = {
        val id = counter
        pool.put(id, text)
        counter += 1
        id
    }

    def delete(id: Int): String = {
        pool.remove(id)
    }
}