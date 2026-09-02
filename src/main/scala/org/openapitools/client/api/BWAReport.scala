package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BWAReport._

case class BWAReport (
  expenses: BWAExpenses,
generatedAt: String,
period: String,
revenue: BWARevenue,
summary: BWASummary)

object BWAReport {
  import DateTimeCodecs._

  implicit val BWAReportCodecJson: CodecJson[BWAReport] = CodecJson.derive[BWAReport]
  implicit val BWAReportDecoder: EntityDecoder[BWAReport] = jsonOf[BWAReport]
  implicit val BWAReportEncoder: EntityEncoder[BWAReport] = jsonEncoderOf[BWAReport]
}
