package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import RecurringTemplateCreate._

case class RecurringTemplateCreate (
  endDate: Option[LocalDate],
executionInterval: String,
executionStatus: ExecutionStatus,
finalize: Option[Boolean],
lastExecutedAt: Option[OffsetDateTime],
name: String,
nextExecutionAt: Option[OffsetDateTime],
startDate: LocalDate,
templateType: RecurringTemplateType,
voucherData: Option[AnyType])

object RecurringTemplateCreate {
  import DateTimeCodecs._

  implicit val RecurringTemplateCreateCodecJson: CodecJson[RecurringTemplateCreate] = CodecJson.derive[RecurringTemplateCreate]
  implicit val RecurringTemplateCreateDecoder: EntityDecoder[RecurringTemplateCreate] = jsonOf[RecurringTemplateCreate]
  implicit val RecurringTemplateCreateEncoder: EntityEncoder[RecurringTemplateCreate] = jsonEncoderOf[RecurringTemplateCreate]
}
