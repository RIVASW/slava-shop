package controllers

/**
 * Created by Ivan on 10.12.2015.
 */

import play.api.libs.json.{JsError, Json}
import play.api.mvc._
import models._

object ShoppingCartController extends Controller{

  def authenticatedAction(f: (ShoppingCartItem, String) => Unit) =  Authenticated(BodyParsers.parse.json){ request =>
    val item = request.body.validate[ShoppingCartItem]
    item.fold(
      errors => {
        BadRequest(Json.obj("status" -> "Error", "message" -> JsError.toFlatJson(errors)))
      },
      item => {
        f(item, request.loginName)
        Ok(Json.obj("status" -> "Ok"))
      }
    )
  }

  def add =  authenticatedAction(ShoppingCart.add)
  def remove =  authenticatedAction(ShoppingCart.remove)

}
