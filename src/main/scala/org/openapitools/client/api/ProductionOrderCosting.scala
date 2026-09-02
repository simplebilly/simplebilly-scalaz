package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ProductionOrderCosting._

case class ProductionOrderCosting (
  /* material_cost_total ÷ quantity. */
  costPerUnit: String,
/* \"actual\" when costed from stock-movement consumption, else \"planned\". */
  costSource: String,
lines: List[CostingLine],
/* sale_price − cost_per_unit. */
  marginPerUnit: Option[String],
/* margin_per_unit ÷ cost_per_unit as a percentage. */
  marginPercent: Option[String],
/* Total material cost for the whole order. */
  materialCostTotal: String,
orderNumber: String,
productionOrderId: UUID,
quantity: Long,
/* Finished product's sale price per unit (used to compute margin). */
  salePrice: Option[String],
status: String)

object ProductionOrderCosting {
  import DateTimeCodecs._

  implicit val ProductionOrderCostingCodecJson: CodecJson[ProductionOrderCosting] = CodecJson.derive[ProductionOrderCosting]
  implicit val ProductionOrderCostingDecoder: EntityDecoder[ProductionOrderCosting] = jsonOf[ProductionOrderCosting]
  implicit val ProductionOrderCostingEncoder: EntityEncoder[ProductionOrderCosting] = jsonEncoderOf[ProductionOrderCosting]
}
