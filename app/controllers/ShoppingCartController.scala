package controllers

/**
 * Created by Ivan on 10.12.2015.
 */
import play.api.mvc._

object ShoppingCartController extends Controller{

  def add =  Authenticated{ request =>
    Ok("Ok")
  }

}
