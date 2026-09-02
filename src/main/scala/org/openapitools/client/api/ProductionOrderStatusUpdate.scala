package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ProductionOrderStatusUpdate._

case class ProductionOrderStatusUpdate (
  status: String)

object ProductionOrderStatusUpdate {
  import DateTimeCodecs._

  implicit val ProductionOrderStatusUpdateCodecJson: CodecJson[ProductionOrderStatusUpdate] = CodecJson.derive[ProductionOrderStatusUpdate]
  implicit val ProductionOrderStatusUpdateDecoder: EntityDecoder[ProductionOrderStatusUpdate] = jsonOf[ProductionOrderStatusUpdate]
  implicit val ProductionOrderStatusUpdateEncoder: EntityEncoder[ProductionOrderStatusUpdate] = jsonEncoderOf[ProductionOrderStatusUpdate]
}
