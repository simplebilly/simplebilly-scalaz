package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import GdprApiKey._

case class GdprApiKey (
  createdAt: OffsetDateTime,
expiresAt: Option[OffsetDateTime],
id: UUID,
keyId: UUID,
name: String,
revoked: Boolean)

object GdprApiKey {
  import DateTimeCodecs._

  implicit val GdprApiKeyCodecJson: CodecJson[GdprApiKey] = CodecJson.derive[GdprApiKey]
  implicit val GdprApiKeyDecoder: EntityDecoder[GdprApiKey] = jsonOf[GdprApiKey]
  implicit val GdprApiKeyEncoder: EntityEncoder[GdprApiKey] = jsonEncoderOf[GdprApiKey]
}
