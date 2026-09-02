package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import LoginRequest._

case class LoginRequest (
  email: String,
password: String,
totpCode: Option[String])

object LoginRequest {
  import DateTimeCodecs._

  implicit val LoginRequestCodecJson: CodecJson[LoginRequest] = CodecJson.derive[LoginRequest]
  implicit val LoginRequestDecoder: EntityDecoder[LoginRequest] = jsonOf[LoginRequest]
  implicit val LoginRequestEncoder: EntityEncoder[LoginRequest] = jsonEncoderOf[LoginRequest]
}
