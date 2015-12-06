package models
import play.api.libs.json.Json
/**
 * Created by ivanv_000 on 05.12.2015.
 */
object Product {
  case class Product(id: Int, article: String, name: String)
  case class Analog(article: String, analogs:List[String])

  implicit val productWrites = Json.writes[Product]
  implicit val productReads = Json.reads[Product]


  var products = List(Product(1, "121233456", "MarkovoKaratin type1")
    , Product(2, "1212667fsdf", "MarkovoKaratin type2")
    , Product(3, "231733456", "MarkovoFuckatin typeZero")
    , Product(4, "77733456", "MarkovoDuradin typeDuDu")
  )

  var analogs = List(Analog("121233456", List("1212667fsdf", "77733456"))
    , Analog("1212667fsdf", List("121233456", "77733456"))
    , Analog("77733456", List("1212667fsdf", "121233456"))
  )

  def findByArticleStartsWith(article: String) = products.filter(_.article.startsWith(article))
}
