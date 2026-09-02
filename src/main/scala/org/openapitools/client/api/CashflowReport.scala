package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CashflowReport._

case class CashflowReport (
  closingBalance: Double,
financingCashflow: Double,
investingCashflow: Double,
netCashflow: Double,
openingBalance: Double,
operatingCashflow: Double,
period: String)

object CashflowReport {
  import DateTimeCodecs._

  implicit val CashflowReportCodecJson: CodecJson[CashflowReport] = CodecJson.derive[CashflowReport]
  implicit val CashflowReportDecoder: EntityDecoder[CashflowReport] = jsonOf[CashflowReport]
  implicit val CashflowReportEncoder: EntityEncoder[CashflowReport] = jsonEncoderOf[CashflowReport]
}
