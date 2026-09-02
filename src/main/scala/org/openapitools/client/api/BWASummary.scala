package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BWASummary._

case class BWASummary (
  grossProfit: String,
netProfit: String,
openInvoicesCount: Long,
openInvoicesTotal: String,
overdueInvoicesCount: Long,
overdueInvoicesTotal: String,
profitMargin: Double)

object BWASummary {
  import DateTimeCodecs._

  implicit val BWASummaryCodecJson: CodecJson[BWASummary] = CodecJson.derive[BWASummary]
  implicit val BWASummaryDecoder: EntityDecoder[BWASummary] = jsonOf[BWASummary]
  implicit val BWASummaryEncoder: EntityEncoder[BWASummary] = jsonEncoderOf[BWASummary]
}
