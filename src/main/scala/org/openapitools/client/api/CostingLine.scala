package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import CostingLine._

case class CostingLine (
  /* total_quantity × unit_purchase_price (0 when price unknown). */
  lineCost: String,
name: String,
productId: UUID,
/* Component quantity required per finished unit. */
  quantityPerUnit: Long,
sku: String,
/* Total component quantity consumed by this order. */
  totalQuantity: Long,
unitPurchasePrice: Option[String])

object CostingLine {
  import DateTimeCodecs._

  implicit val CostingLineCodecJson: CodecJson[CostingLine] = CodecJson.derive[CostingLine]
  implicit val CostingLineDecoder: EntityDecoder[CostingLine] = jsonOf[CostingLine]
  implicit val CostingLineEncoder: EntityEncoder[CostingLine] = jsonEncoderOf[CostingLine]
}
