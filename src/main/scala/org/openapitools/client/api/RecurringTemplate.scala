package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import RecurringTemplate._

case class RecurringTemplate (
  createdAt: String,
deletedAt: Option[String],
endDate: Option[LocalDate],
executionInterval: String,
executionStatus: String,
finalize: Boolean,
lastExecutedAt: Option[OffsetDateTime],
name: String,
nextExecutionAt: Option[OffsetDateTime],
startDate: LocalDate,
templateId: String,
templateType: String,
updatedAt: Option[String],
voucherData: AnyType)

object RecurringTemplate {
  import DateTimeCodecs._

  implicit val RecurringTemplateCodecJson: CodecJson[RecurringTemplate] = CodecJson.derive[RecurringTemplate]
  implicit val RecurringTemplateDecoder: EntityDecoder[RecurringTemplate] = jsonOf[RecurringTemplate]
  implicit val RecurringTemplateEncoder: EntityEncoder[RecurringTemplate] = jsonEncoderOf[RecurringTemplate]
}
