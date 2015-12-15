package models

import play.api.mvc.Request

/**
 * Created by ivanv_000 on 12.12.2015.
 */
trait AuthenticatedRequest[+A] extends Request[A] {
  val loginName: String
}

object AuthenticatedRequest {
  def apply[A](ln: String, r: Request[A]) = new AuthenticatedRequest[A] {
    def id = r.id
    def tags = r.tags
    def uri = r.uri
    def path = r.path
    def method = r.method
    def version = r.version
    def queryString = r.queryString
    def headers = r.headers
    def username = None
    def secure = false
    lazy val remoteAddress = r.remoteAddress
    val body = r.body
    val loginName = ln
  }
}
