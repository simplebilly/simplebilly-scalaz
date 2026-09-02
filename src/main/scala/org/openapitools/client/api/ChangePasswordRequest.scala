package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ChangePasswordRequest._

case class ChangePasswordRequest (
  currentPassword: String,
newPassword: String)

object ChangePasswordRequest {
  import DateTimeCodecs._

  implicit val ChangePasswordRequestCodecJson: CodecJson[ChangePasswordRequest] = CodecJson.derive[ChangePasswordRequest]
  implicit val ChangePasswordRequestDecoder: EntityDecoder[ChangePasswordRequest] = jsonOf[ChangePasswordRequest]
  implicit val ChangePasswordRequestEncoder: EntityEncoder[ChangePasswordRequest] = jsonEncoderOf[ChangePasswordRequest]
}
