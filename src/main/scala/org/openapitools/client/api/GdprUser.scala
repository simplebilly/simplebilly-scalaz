package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import GdprUser._

case class GdprUser (
  createdAt: OffsetDateTime,
email: String,
id: UUID,
name: String)

object GdprUser {
  import DateTimeCodecs._

  implicit val GdprUserCodecJson: CodecJson[GdprUser] = CodecJson.derive[GdprUser]
  implicit val GdprUserDecoder: EntityDecoder[GdprUser] = jsonOf[GdprUser]
  implicit val GdprUserEncoder: EntityEncoder[GdprUser] = jsonEncoderOf[GdprUser]
}
