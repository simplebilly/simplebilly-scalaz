package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AuthResponse._

case class AuthResponse (
  accessToken: Option[String],
message: Option[String],
refreshToken: Option[String],
success: Boolean,
user: Option[Model])

object AuthResponse {
  import DateTimeCodecs._

  implicit val AuthResponseCodecJson: CodecJson[AuthResponse] = CodecJson.derive[AuthResponse]
  implicit val AuthResponseDecoder: EntityDecoder[AuthResponse] = jsonOf[AuthResponse]
  implicit val AuthResponseEncoder: EntityEncoder[AuthResponse] = jsonEncoderOf[AuthResponse]
}
