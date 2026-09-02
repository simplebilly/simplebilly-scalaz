package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import GdprActivity._

case class GdprActivity (
  action: String,
createdAt: OffsetDateTime,
description: Option[String],
id: UUID,
tenantId: UUID)

object GdprActivity {
  import DateTimeCodecs._

  implicit val GdprActivityCodecJson: CodecJson[GdprActivity] = CodecJson.derive[GdprActivity]
  implicit val GdprActivityDecoder: EntityDecoder[GdprActivity] = jsonOf[GdprActivity]
  implicit val GdprActivityEncoder: EntityEncoder[GdprActivity] = jsonEncoderOf[GdprActivity]
}
