package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ResetPasswordRequest._

case class ResetPasswordRequest (
  newPassword: String,
token: String)

object ResetPasswordRequest {
  import DateTimeCodecs._

  implicit val ResetPasswordRequestCodecJson: CodecJson[ResetPasswordRequest] = CodecJson.derive[ResetPasswordRequest]
  implicit val ResetPasswordRequestDecoder: EntityDecoder[ResetPasswordRequest] = jsonOf[ResetPasswordRequest]
  implicit val ResetPasswordRequestEncoder: EntityEncoder[ResetPasswordRequest] = jsonEncoderOf[ResetPasswordRequest]
}
