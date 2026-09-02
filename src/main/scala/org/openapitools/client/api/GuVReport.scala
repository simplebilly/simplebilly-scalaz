package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GuVReport._

case class GuVReport (
  expenses: List[GuVItem],
generatedAt: String,
netIncome: String,
period: String,
revenue: List[GuVItem],
totalExpenses: String,
totalRevenue: String)

object GuVReport {
  import DateTimeCodecs._

  implicit val GuVReportCodecJson: CodecJson[GuVReport] = CodecJson.derive[GuVReport]
  implicit val GuVReportDecoder: EntityDecoder[GuVReport] = jsonOf[GuVReport]
  implicit val GuVReportEncoder: EntityEncoder[GuVReport] = jsonEncoderOf[GuVReport]
}
