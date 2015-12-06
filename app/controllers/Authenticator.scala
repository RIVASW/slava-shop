package controllers

import controllers.Application._
import models.AuthenticationData.AuthenticationData
import models.{UserSid, User}
import play.api.libs.json.{JsError, Json}
import play.api.mvc.{Action, BodyParsers, Controller}

/**
 * Created by ivanv_000 on 06.12.2015.
 */
object Authenticator extends Controller{
  def checkLoginNameAndPassword(loginName: String, password: String):Option[ String] = {
    User.findByLoginAndPassword(loginName, password).map{ _ => UserSid.addSid(loginName) }
  }
  def getLoginNameBySid(sid: String):Option[String] = UserSid.getLoginName(sid)
  def isAuthenticated(sid: String) = UserSid.getLoginName(sid).isDefined

  def authenticate = Action(BodyParsers.parse.json) { request =>
    val ad = request.body.validate[AuthenticationData]
    ad.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
      },
      ad => {
        checkLoginNameAndPassword(ad.loginName, ad.password).
          map{ sid => Ok(Json.obj("status" -> "OK")).withSession(("SID",sid))}
          .getOrElse(Ok(Json.obj("status" -> "OK", "message" -> "wrong name or password")))
      }
    )
  }

}
