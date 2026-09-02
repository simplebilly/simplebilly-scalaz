package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import AutomationDto._

case class AutomationDto (
  automationKey: String,
config: AnyType,
defaultDay: Option[Integer],
description: String,
enabled: Boolean,
kind: String,
lastRunAt: Option[OffsetDateTime],
nextRunAt: Option[OffsetDateTime],
scheduleKind: String)

object AutomationDto {
  import DateTimeCodecs._

  implicit val AutomationDtoCodecJson: CodecJson[AutomationDto] = CodecJson.derive[AutomationDto]
  implicit val AutomationDtoDecoder: EntityDecoder[AutomationDto] = jsonOf[AutomationDto]
  implicit val AutomationDtoEncoder: EntityEncoder[AutomationDto] = jsonEncoderOf[AutomationDto]
}
