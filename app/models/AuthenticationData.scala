package models
import play.api.libs.json.Json

/**
 * Created by ivanv_000 on 06.12.2015.
 */
case class AuthenticationData(loginName: String, password: String)

object AuthenticationData {
  implicit val authenticationDataWrites = Json.writes[AuthenticationData]
  implicit val authenticationDataReads = Json.reads[AuthenticationData]

}
