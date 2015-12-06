package Utils

/**
 * Created by ivanv_000 on 06.12.2015.
 */
object RandomStringGenerator {
  val random = new scala.util.Random(new java.security.SecureRandom())

  def randomString(alphabet: String)(n: Int): String =
    Stream.continually(random.nextInt(alphabet.size)).map(alphabet).take(n).mkString

  def randomAlphanumericString(n: Int) =
    randomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")(n)
}
