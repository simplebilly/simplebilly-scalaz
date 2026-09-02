package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EBilanzReport._

case class EBilanzReport (
  accountOverview: List[AccountOverview],
balanceSheet: BalanceSheet,
generatedAt: String,
incomeStatement: IncomeStatement,
period: String,
vatSummary: VatSummary)

object EBilanzReport {
  import DateTimeCodecs._

  implicit val EBilanzReportCodecJson: CodecJson[EBilanzReport] = CodecJson.derive[EBilanzReport]
  implicit val EBilanzReportDecoder: EntityDecoder[EBilanzReport] = jsonOf[EBilanzReport]
  implicit val EBilanzReportEncoder: EntityEncoder[EBilanzReport] = jsonEncoderOf[EBilanzReport]
}
