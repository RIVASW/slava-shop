package controllers

import scala.concurrent.Future
import play.api.mvc._
import play.api.mvc.Results._
import play.api.libs.json.Json
import models.AuthenticatedRequest


/**
 * Created by ivanv_000 on 12.12.2015.
 */

object Authenticated extends ActionBuilder[AuthenticatedRequest]{
  val unauthenticated = Future.successful(Ok(Json.toJson("Status" -> "Unauthenticated")))

  def invokeBlock[A](request: Request[A], block: (AuthenticatedRequest[A]) => Future[Result]) = {
    request.session.get("SID").map {sid =>
      Authenticator.getLoginNameBySid(sid)
        .map{r => block(AuthenticatedRequest[A](Some(r), request))}
        .getOrElse(unauthenticated)}
      .getOrElse(unauthenticated)
  }
}
