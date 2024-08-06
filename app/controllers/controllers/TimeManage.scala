package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import java.time.{Clock, ZoneId}
import java.time.Duration

@Singleton
class TimeManage @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def getCurrentTime() = Action { request: Request[AnyContent] => 
    val currentTime = Clock.system(ZoneId.systemDefault()).instant().toString()
    Ok(currentTime)
  }

  def modifyTime() = Action { reqest: Request[AnyContent] => 
    val currentTime = Clock.system(ZoneId.systemDefault())
    val offsetTIme = Clock.offset(currentTime, Duration.ofMinutes(30)).instant().toString()
    Ok(offsetTIme)
  }
}
