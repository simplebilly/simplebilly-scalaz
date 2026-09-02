package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmissionsReport._

case class EmissionsReport (
  byCategory: List[CategoryTotal],
byScope: List[ScopeTotal],
byYear: List[YearTotal],
dataQuality: DataQuality,
intensityPerEmployee: Option[Double],
/* tCO2e per million EUR net revenue. */
  intensityPerRevenueMio: Option[Double],
/* Sum of paid/sent/partially-paid invoices (EUR net) in the year. */
  netRevenue: Option[Double],
/* Spend-based estimate from bookkeeping payments (EXIOBASE factor). */
  spendBasedEstimateTco2e: Option[Double],
targets: List[TargetProgress],
totalTco2e: String)

object EmissionsReport {
  import DateTimeCodecs._

  implicit val EmissionsReportCodecJson: CodecJson[EmissionsReport] = CodecJson.derive[EmissionsReport]
  implicit val EmissionsReportDecoder: EntityDecoder[EmissionsReport] = jsonOf[EmissionsReport]
  implicit val EmissionsReportEncoder: EntityEncoder[EmissionsReport] = jsonEncoderOf[EmissionsReport]
}
