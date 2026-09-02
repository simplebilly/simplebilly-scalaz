package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RevenueItem._

case class RevenueItem (
  amount: String,
category: String,
percentage: Double)

object RevenueItem {
  import DateTimeCodecs._

  implicit val RevenueItemCodecJson: CodecJson[RevenueItem] = CodecJson.derive[RevenueItem]
  implicit val RevenueItemDecoder: EntityDecoder[RevenueItem] = jsonOf[RevenueItem]
  implicit val RevenueItemEncoder: EntityEncoder[RevenueItem] = jsonEncoderOf[RevenueItem]
}
