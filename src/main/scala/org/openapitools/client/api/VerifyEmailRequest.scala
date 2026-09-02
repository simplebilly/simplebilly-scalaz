package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import VerifyEmailRequest._

case class VerifyEmailRequest (
  token: String)

object VerifyEmailRequest {
  import DateTimeCodecs._

  implicit val VerifyEmailRequestCodecJson: CodecJson[VerifyEmailRequest] = CodecJson.derive[VerifyEmailRequest]
  implicit val VerifyEmailRequestDecoder: EntityDecoder[VerifyEmailRequest] = jsonOf[VerifyEmailRequest]
  implicit val VerifyEmailRequestEncoder: EntityEncoder[VerifyEmailRequest] = jsonEncoderOf[VerifyEmailRequest]
}
