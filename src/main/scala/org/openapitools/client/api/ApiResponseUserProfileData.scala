package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import ApiResponseUserProfileData._

case class ApiResponseUserProfileData (
  createdAt: OffsetDateTime,
email: String,
emailVerified: Boolean,
firstName: String,
fullName: String,
id: UUID,
lastName: String)

object ApiResponseUserProfileData {
  import DateTimeCodecs._

  implicit val ApiResponseUserProfileDataCodecJson: CodecJson[ApiResponseUserProfileData] = CodecJson.derive[ApiResponseUserProfileData]
  implicit val ApiResponseUserProfileDataDecoder: EntityDecoder[ApiResponseUserProfileData] = jsonOf[ApiResponseUserProfileData]
  implicit val ApiResponseUserProfileDataEncoder: EntityEncoder[ApiResponseUserProfileData] = jsonEncoderOf[ApiResponseUserProfileData]
}
