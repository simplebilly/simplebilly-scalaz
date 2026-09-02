package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BWARevenue._

case class BWARevenue (
  revenueBreakdown: List[RevenueItem],
totalRevenue: String)

object BWARevenue {
  import DateTimeCodecs._

  implicit val BWARevenueCodecJson: CodecJson[BWARevenue] = CodecJson.derive[BWARevenue]
  implicit val BWARevenueDecoder: EntityDecoder[BWARevenue] = jsonOf[BWARevenue]
  implicit val BWARevenueEncoder: EntityEncoder[BWARevenue] = jsonEncoderOf[BWARevenue]
}
