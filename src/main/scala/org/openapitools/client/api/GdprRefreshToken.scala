package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import GdprRefreshToken._

case class GdprRefreshToken (
  createdAt: OffsetDateTime,
expiresAt: OffsetDateTime,
id: UUID,
revokedAt: Option[OffsetDateTime],
tenantId: UUID)

object GdprRefreshToken {
  import DateTimeCodecs._

  implicit val GdprRefreshTokenCodecJson: CodecJson[GdprRefreshToken] = CodecJson.derive[GdprRefreshToken]
  implicit val GdprRefreshTokenDecoder: EntityDecoder[GdprRefreshToken] = jsonOf[GdprRefreshToken]
  implicit val GdprRefreshTokenEncoder: EntityEncoder[GdprRefreshToken] = jsonEncoderOf[GdprRefreshToken]
}
