package controllers


import play.api.libs.json._
import play.api.mvc._

import models.Product._

object Application extends Controller {

  def AuthenticatedAction(f: Request[AnyContent] => Result):
  Action[AnyContent] = {
    Action { request =>
      request.session.get("SID").map {sid =>
        Authenticator.getLoginNameBySid(sid)
          .map{_ => f(request)}.getOrElse(Unauthorized("HTTP/1.1 401 Unauthorized"))
      } .getOrElse(Unauthorized("HTTP/1.1 401 Unauthorized"))
    }
  }

  def listProducts(article: String) = AuthenticatedAction{ request =>
    Ok(Json.toJson(findByArticleStartsWith(article)))
  }

}
