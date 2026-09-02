package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.util.UUID

import ProductionOrder._

case class ProductionOrder (
  /* References the BOM entity. */
  bomId: Option[UUID],
/* JSON snapshot of the BOM components at creation time. */
  components: Option[AnyType],
endDate: Option[LocalDate],
notes: Option[String],
orderNumber: String,
/* The finished product to manufacture. References the product entity. */
  productId: UUID,
/* Quantity of finished product to produce. */
  quantity: Long,
/* Warehouse components are consumed from. References the warehouse entity. */
  sourceWarehouseId: Option[String],
startDate: Option[LocalDate],
/* One of: planned | in_production | completed | cancelled */
  status: Option[ProductionOrderStatus],
/* Warehouse the finished product is added to. References the warehouse entity. */
  targetWarehouseId: Option[String])

object ProductionOrder {
  import DateTimeCodecs._

  implicit val ProductionOrderCodecJson: CodecJson[ProductionOrder] = CodecJson.derive[ProductionOrder]
  implicit val ProductionOrderDecoder: EntityDecoder[ProductionOrder] = jsonOf[ProductionOrder]
  implicit val ProductionOrderEncoder: EntityEncoder[ProductionOrder] = jsonEncoderOf[ProductionOrder]
}
