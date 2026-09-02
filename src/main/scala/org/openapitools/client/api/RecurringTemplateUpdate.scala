package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import RecurringTemplateUpdate._

case class RecurringTemplateUpdate (
  endDate: Option[LocalDate],
executionInterval: Option[String],
executionStatus: Option[ExecutionStatus],
finalize: Option[Boolean],
lastExecutedAt: Option[OffsetDateTime],
name: Option[String],
nextExecutionAt: Option[OffsetDateTime],
startDate: Option[LocalDate],
templateType: Option[RecurringTemplateType],
voucherData: Option[AnyType])

object RecurringTemplateUpdate {
  import DateTimeCodecs._

  implicit val RecurringTemplateUpdateCodecJson: CodecJson[RecurringTemplateUpdate] = CodecJson.derive[RecurringTemplateUpdate]
  implicit val RecurringTemplateUpdateDecoder: EntityDecoder[RecurringTemplateUpdate] = jsonOf[RecurringTemplateUpdate]
  implicit val RecurringTemplateUpdateEncoder: EntityEncoder[RecurringTemplateUpdate] = jsonEncoderOf[RecurringTemplateUpdate]
}
