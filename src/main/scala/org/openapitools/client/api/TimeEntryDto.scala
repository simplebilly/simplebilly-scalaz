package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID

import TimeEntryDto._

case class TimeEntryDto (
  clockIn: Option[OffsetDateTime],
clockOut: Option[OffsetDateTime],
createdAt: OffsetDateTime,
date: LocalDate,
employeeId: UUID,
hours: Option[String],
notes: Option[String],
timeEntryId: UUID)

object TimeEntryDto {
  import DateTimeCodecs._

  implicit val TimeEntryDtoCodecJson: CodecJson[TimeEntryDto] = CodecJson.derive[TimeEntryDto]
  implicit val TimeEntryDtoDecoder: EntityDecoder[TimeEntryDto] = jsonOf[TimeEntryDto]
  implicit val TimeEntryDtoEncoder: EntityEncoder[TimeEntryDto] = jsonEncoderOf[TimeEntryDto]
}
