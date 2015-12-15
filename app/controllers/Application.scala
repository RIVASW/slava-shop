package controllers


import play.api.libs.json._
import play.api.mvc._

import models.Product._


object Application extends Controller {

  def listProducts(article: String) = Authenticated{ request =>
    Ok(Json.toJson(findByArticleStartsWith(article)))
  }

}
