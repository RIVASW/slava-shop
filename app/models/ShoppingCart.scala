package models

/**
 * Created by Ivan on 10.12.2015.
 */
object ShoppingCart {
  var shoppingCarts = Map[String, Map[String, Int]]()

  def addToCart(item: ShoppingCartItem, loginName: String):Unit = { item match {
      case ShoppingCartItem(article, number) => shoppingCarts = shoppingCarts +
        (loginName -> shoppingCarts.get(loginName)
        .map { m => m + (article -> m.get(article).map {_ + number}
          .getOrElse(number))
        }
        .getOrElse(Map[String, Int](article -> number)))
    }
  }

  def getUserCart(loginName: String):Option[List[ShoppingCartItem]] = shoppingCarts.get(loginName)
    .map(for(m <- _) yield new ShoppingCartItem(m._1, m._2)).map(_.toList)
}
