package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ProductionOrderStatus._

case class ProductionOrderStatus (
  
object ProductionOrderStatus {
  import DateTimeCodecs._

  implicit val ProductionOrderStatusCodecJson: CodecJson[ProductionOrderStatus] = CodecJson.derive[ProductionOrderStatus]
  implicit val ProductionOrderStatusDecoder: EntityDecoder[ProductionOrderStatus] = jsonOf[ProductionOrderStatus]
  implicit val ProductionOrderStatusEncoder: EntityEncoder[ProductionOrderStatus] = jsonEncoderOf[ProductionOrderStatus]
}
