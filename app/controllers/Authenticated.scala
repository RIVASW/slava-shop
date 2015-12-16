package controllers

import scala.concurrent.Future
import play.api.mvc._
import play.api.mvc.Results._
import play.api.libs.json._
import models.AuthenticatedRequest


/**
 * Created by ivanv_000 on 12.12.2015.
 */

object Authenticated extends ActionBuilder[AuthenticatedRequest]{

  def invokeBlock[A](request: Request[A], block: (AuthenticatedRequest[A]) => Future[Result]) = {
    request.session.get("SID").map {sid =>
      Authenticator.getLoginNameBySid(sid)
        .map{ln => block(AuthenticatedRequest[A](ln, request))}
        .getOrElse(unauthenticated)}
      .getOrElse(unauthenticated)
  }

  lazy val unauthenticated = Future.successful(Ok(Json.obj("Status" -> "Unauthenticated",
    "message" -> "You need to login to perform this opeartion")))
}
