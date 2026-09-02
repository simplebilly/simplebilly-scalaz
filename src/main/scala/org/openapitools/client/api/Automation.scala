package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import Automation._

case class Automation (
  automationKey: String,
config: AnyType,
createdAt: OffsetDateTime,
enabled: Boolean,
lastRunAt: Option[OffsetDateTime],
nextRunAt: Option[OffsetDateTime],
tenantId: UUID,
updatedAt: OffsetDateTime)

object Automation {
  import DateTimeCodecs._

  implicit val AutomationCodecJson: CodecJson[Automation] = CodecJson.derive[Automation]
  implicit val AutomationDecoder: EntityDecoder[Automation] = jsonOf[Automation]
  implicit val AutomationEncoder: EntityEncoder[Automation] = jsonEncoderOf[Automation]
}
