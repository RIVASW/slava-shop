package controllers

import scala.concurrent.Future
import play.api.mvc._
import play.api.mvc.Results._
import play.api.libs.json.Json}


/**
 * Created by ivanv_000 on 12.12.2015.
 */

object Authenticated extends ActionBuilder[Request]{
  val unauthenticated = Future.successful(Ok(Json.toJson("Status" -> "Unauthenticated", "message" -> "You need to login to perform this opeartion")))

  def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    request.session.get("SID").map {sid =>
      Authenticator.getLoginNameBySid(sid)
        .map{_ => block(request)}
        .getOrElse(unauthenticated)}
      .getOrElse(unauthenticated)
  }
}
