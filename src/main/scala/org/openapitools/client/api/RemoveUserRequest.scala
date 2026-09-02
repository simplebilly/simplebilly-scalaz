package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RemoveUserRequest._

case class RemoveUserRequest (
  email: String)

object RemoveUserRequest {
  import DateTimeCodecs._

  implicit val RemoveUserRequestCodecJson: CodecJson[RemoveUserRequest] = CodecJson.derive[RemoveUserRequest]
  implicit val RemoveUserRequestDecoder: EntityDecoder[RemoveUserRequest] = jsonOf[RemoveUserRequest]
  implicit val RemoveUserRequestEncoder: EntityEncoder[RemoveUserRequest] = jsonEncoderOf[RemoveUserRequest]
}
