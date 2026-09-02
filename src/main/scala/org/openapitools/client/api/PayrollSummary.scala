package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import PayrollSummary._

case class PayrollSummary (
  firstName: String,
hourlyGross: Option[String],
id: UUID,
jobTitle: String,
lastName: String,
monthlySalary: Option[String],
months: List[PayrollMonth],
weeklyHours: Option[String],
year: Integer)

object PayrollSummary {
  import DateTimeCodecs._

  implicit val PayrollSummaryCodecJson: CodecJson[PayrollSummary] = CodecJson.derive[PayrollSummary]
  implicit val PayrollSummaryDecoder: EntityDecoder[PayrollSummary] = jsonOf[PayrollSummary]
  implicit val PayrollSummaryEncoder: EntityEncoder[PayrollSummary] = jsonEncoderOf[PayrollSummary]
}
