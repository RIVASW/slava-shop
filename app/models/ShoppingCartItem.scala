package models

import play.api.libs.json.Json

/**
 * Created by Ivan on 10.12.2015.
 */
object ShoppingCartItem {
  case class ShoppingCartItem(article: String, number: Int)

  implicit val shoppingCartItemWrites = Json.writes[ShoppingCartItem]
  implicit val shoppingCartItemReads = Json.reads[ShoppingCartItem]

}
