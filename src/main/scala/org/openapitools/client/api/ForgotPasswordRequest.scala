package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ForgotPasswordRequest._

case class ForgotPasswordRequest (
  email: String)

object ForgotPasswordRequest {
  import DateTimeCodecs._

  implicit val ForgotPasswordRequestCodecJson: CodecJson[ForgotPasswordRequest] = CodecJson.derive[ForgotPasswordRequest]
  implicit val ForgotPasswordRequestDecoder: EntityDecoder[ForgotPasswordRequest] = jsonOf[ForgotPasswordRequest]
  implicit val ForgotPasswordRequestEncoder: EntityEncoder[ForgotPasswordRequest] = jsonEncoderOf[ForgotPasswordRequest]
}
