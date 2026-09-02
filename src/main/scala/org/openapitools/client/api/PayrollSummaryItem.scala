package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PayrollSummaryItem._

case class PayrollSummaryItem (
  employeeCount: Integer,
month: String,
status: PayrollRunStatus,
totalEmployerCost: String,
totalGross: String,
totalNet: String,
year: Integer)

object PayrollSummaryItem {
  import DateTimeCodecs._

  implicit val PayrollSummaryItemCodecJson: CodecJson[PayrollSummaryItem] = CodecJson.derive[PayrollSummaryItem]
  implicit val PayrollSummaryItemDecoder: EntityDecoder[PayrollSummaryItem] = jsonOf[PayrollSummaryItem]
  implicit val PayrollSummaryItemEncoder: EntityEncoder[PayrollSummaryItem] = jsonEncoderOf[PayrollSummaryItem]
}
