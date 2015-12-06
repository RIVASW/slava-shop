package models

import Utils.RandomStringGenerator

/**
 * Created by ivanv_000 on 05.12.2015.
 */
object UserSid {
  case class UserSid(loginName: String, sid: String, timeStamp: Long )

  var userSids = List[UserSid]()
  val sidLength = 50
  val sidLifeTime = 8.64e7

  def addSid(loginName: String) = {
    val sid = RandomStringGenerator.randomAlphanumericString(sidLength)
    var now = java.lang.System.currentTimeMillis();
    userSids = UserSid(loginName, sid, now) :: userSids
    sid
  }

  def getLoginName(sid: String):Option[String] = {
    var now = java.lang.System.currentTimeMillis();
    userSids.find(_.sid == sid).map{ s => s match {
        case UserSid(loginName, _, there) if (now - there < sidLifeTime) => loginName
      }
    }
  }

  def removeExpiredSids = {
    var now = java.lang.System.currentTimeMillis();
    userSids = userSids.filter(now - _.timeStamp < sidLifeTime)
  }
}
