package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import Model._

case class Model (
  backupCodes: List[String],
createdAt: OffsetDateTime,
deletedAt: Option[OffsetDateTime],
email: String,
emailVerified: Boolean,
id: UUID,
isActive: Boolean,
isTotpEnabled: Boolean,
lastLogin: Option[OffsetDateTime],
name: String,
oauthId: Option[String],
oauthProvider: Option[String],
/* Set on password change; auth/refresh tokens issued before this timestamp are rejected by the auth middleware. */
  passwordChangedAt: Option[OffsetDateTime],
passwordHash: String,
picture: Option[String],
/* When the user accepted the data privacy policy (GDPR consent record). */
  privacyAcceptedAt: Option[OffsetDateTime],
totpSecret: Option[String],
updatedAt: OffsetDateTime)

object Model {
  import DateTimeCodecs._

  implicit val ModelCodecJson: CodecJson[Model] = CodecJson.derive[Model]
  implicit val ModelDecoder: EntityDecoder[Model] = jsonOf[Model]
  implicit val ModelEncoder: EntityEncoder[Model] = jsonEncoderOf[Model]
}
