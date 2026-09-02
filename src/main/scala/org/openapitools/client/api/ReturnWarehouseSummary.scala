package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ReturnWarehouseSummary._

case class ReturnWarehouseSummary (
  itemsRestocked: Long,
itemsScrapped: Long,
returns: Long,
warehouseId: Option[String])

object ReturnWarehouseSummary {
  import DateTimeCodecs._

  implicit val ReturnWarehouseSummaryCodecJson: CodecJson[ReturnWarehouseSummary] = CodecJson.derive[ReturnWarehouseSummary]
  implicit val ReturnWarehouseSummaryDecoder: EntityDecoder[ReturnWarehouseSummary] = jsonOf[ReturnWarehouseSummary]
  implicit val ReturnWarehouseSummaryEncoder: EntityEncoder[ReturnWarehouseSummary] = jsonEncoderOf[ReturnWarehouseSummary]
}
