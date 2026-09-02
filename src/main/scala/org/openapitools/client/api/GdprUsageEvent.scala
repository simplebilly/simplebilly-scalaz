package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import GdprUsageEvent._

case class GdprUsageEvent (
  createdAt: OffsetDateTime,
eventType: String,
id: UUID,
quantity: Integer,
tenantId: UUID)

object GdprUsageEvent {
  import DateTimeCodecs._

  implicit val GdprUsageEventCodecJson: CodecJson[GdprUsageEvent] = CodecJson.derive[GdprUsageEvent]
  implicit val GdprUsageEventDecoder: EntityDecoder[GdprUsageEvent] = jsonOf[GdprUsageEvent]
  implicit val GdprUsageEventEncoder: EntityEncoder[GdprUsageEvent] = jsonEncoderOf[GdprUsageEvent]
}
