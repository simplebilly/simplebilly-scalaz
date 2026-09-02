package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RegisterRequest._

case class RegisterRequest (
  companyName: String,
email: String,
firstName: String,
lastName: String,
password: String,
/* GDPR consent — registration is rejected unless true. */
  privacyAccepted: Boolean)

object RegisterRequest {
  import DateTimeCodecs._

  implicit val RegisterRequestCodecJson: CodecJson[RegisterRequest] = CodecJson.derive[RegisterRequest]
  implicit val RegisterRequestDecoder: EntityDecoder[RegisterRequest] = jsonOf[RegisterRequest]
  implicit val RegisterRequestEncoder: EntityEncoder[RegisterRequest] = jsonEncoderOf[RegisterRequest]
}
