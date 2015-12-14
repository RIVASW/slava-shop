package models

import play.api.libs.json.Json

/**
 * Created by Ivan on 10.12.2015.
 */
case class ShoppingCartItem(article: String, number: Int)

object ShoppingCartItem {
  implicit val shoppingCartItemWrites = Json.writes[ShoppingCartItem]
  implicit val shoppingCartItemReads = Json.reads[ShoppingCartItem]

}
