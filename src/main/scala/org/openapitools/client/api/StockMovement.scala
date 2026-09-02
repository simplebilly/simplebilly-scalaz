package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import StockMovement._

case class StockMovement (
  /* Signed movement: positive = into stock, negative = out of stock. */
  delta: Long,
/* One of the `MOVEMENT_*` constants. */
  movementType: MovementType,
/* References the product entity. */
  productId: UUID,
/* Absolute quantity moved (always >= 0). */
  quantity: Long,
reason: Option[String],
/* Primary-key of the referencing entity. */
  referenceId: Option[String],
/* Entity that caused the movement, e.g. `goods_receipt`, `stock_transfer`. */
  referenceType: Option[ReferenceType],
/* References the warehouse entity. */
  warehouseId: String)

object StockMovement {
  import DateTimeCodecs._

  implicit val StockMovementCodecJson: CodecJson[StockMovement] = CodecJson.derive[StockMovement]
  implicit val StockMovementDecoder: EntityDecoder[StockMovement] = jsonOf[StockMovement]
  implicit val StockMovementEncoder: EntityEncoder[StockMovement] = jsonEncoderOf[StockMovement]
}
