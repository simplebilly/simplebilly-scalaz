package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import PayrollEntryApi._

case class PayrollEntryApi (
  avEmployee: String,
avEmployer: String,
churchTaxAmount: String,
employee: Option[Employee],
employeeId: UUID,
entryId: UUID,
extraPaymentReason: Option[String],
extraPayments: String,
grossSalary: String,
kvEmployee: String,
kvEmployer: String,
lohnsteuer: String,
netSalary: String,
notes: Option[String],
pvEmployee: String,
pvEmployer: String,
runId: UUID,
rvEmployee: String,
rvEmployer: String,
sickDays: Integer,
soli: String,
status: PayrollRunStatus,
totalDeductions: String,
totalEmployerCost: String,
vacationDaysUsed: Integer)

object PayrollEntryApi {
  import DateTimeCodecs._

  implicit val PayrollEntryApiCodecJson: CodecJson[PayrollEntryApi] = CodecJson.derive[PayrollEntryApi]
  implicit val PayrollEntryApiDecoder: EntityDecoder[PayrollEntryApi] = jsonOf[PayrollEntryApi]
  implicit val PayrollEntryApiEncoder: EntityEncoder[PayrollEntryApi] = jsonEncoderOf[PayrollEntryApi]
}
