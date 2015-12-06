package models

/**
 * Created by ivanv_000 on 05.12.2015.
 */
object User {
  case class User( loginName: String, password: String, realName: String)
  val users = List(User("markov", "pass", "Betta Kavatinovich")
    , User("tolyasha", "bubu", "Jirnaya Buhasha"))

  def findByLoginAndPassword(loginName: String, password: String):Option[User] =
    users.find( u => {u.loginName == loginName && u.password == password} )
}
