package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateProfileRequest._

case class UpdateProfileRequest (
  avatarUrl: Option[String],
firstName: Option[String],
lastName: Option[String],
name: Option[String])

object UpdateProfileRequest {
  import DateTimeCodecs._

  implicit val UpdateProfileRequestCodecJson: CodecJson[UpdateProfileRequest] = CodecJson.derive[UpdateProfileRequest]
  implicit val UpdateProfileRequestDecoder: EntityDecoder[UpdateProfileRequest] = jsonOf[UpdateProfileRequest]
  implicit val UpdateProfileRequestEncoder: EntityEncoder[UpdateProfileRequest] = jsonEncoderOf[UpdateProfileRequest]
}
