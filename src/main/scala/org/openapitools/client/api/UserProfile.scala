package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import UserProfile._

case class UserProfile (
  createdAt: OffsetDateTime,
email: String,
emailVerified: Boolean,
firstName: String,
fullName: String,
id: UUID,
lastName: String)

object UserProfile {
  import DateTimeCodecs._

  implicit val UserProfileCodecJson: CodecJson[UserProfile] = CodecJson.derive[UserProfile]
  implicit val UserProfileDecoder: EntityDecoder[UserProfile] = jsonOf[UserProfile]
  implicit val UserProfileEncoder: EntityEncoder[UserProfile] = jsonEncoderOf[UserProfile]
}
