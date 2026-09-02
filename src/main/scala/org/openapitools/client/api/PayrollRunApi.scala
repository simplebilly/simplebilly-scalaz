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

import PayrollRunApi._

case class PayrollRunApi (
  approvedAt: Option[OffsetDateTime],
approvedBy: Option[UUID],
createdAt: OffsetDateTime,
entries: List[PayrollEntryApi],
month: Integer,
paymentDate: Option[LocalDate],
periodLabel: String,
runId: UUID,
status: PayrollRunStatus,
tenantId: UUID,
totalEmployeeCount: Integer,
totalEmployerCost: String,
totalGross: String,
totalNet: String,
totalSocialSecurity: String,
totalTaxes: String,
updatedAt: Option[OffsetDateTime],
year: Integer)

object PayrollRunApi {
  import DateTimeCodecs._

  implicit val PayrollRunApiCodecJson: CodecJson[PayrollRunApi] = CodecJson.derive[PayrollRunApi]
  implicit val PayrollRunApiDecoder: EntityDecoder[PayrollRunApi] = jsonOf[PayrollRunApi]
  implicit val PayrollRunApiEncoder: EntityEncoder[PayrollRunApi] = jsonEncoderOf[PayrollRunApi]
}
