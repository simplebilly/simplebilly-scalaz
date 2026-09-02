package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.util.UUID

import WarehouseStock._

case class WarehouseStock (
  /* Batch/lot number (Chargennummer) — `None` for non-batched goods. */
  batchNumber: Option[String],
binLocation: Option[String],
/* Expiry date for batch-tracked goods. */
  expiryDate: Option[LocalDate],
productId: UUID,
quantity: Long,
/* JSON array of serial numbers (Seriennummern) in this stock row. */
  serialNumbers: Option[AnyType],
warehouseId: String)

object WarehouseStock {
  import DateTimeCodecs._

  implicit val WarehouseStockCodecJson: CodecJson[WarehouseStock] = CodecJson.derive[WarehouseStock]
  implicit val WarehouseStockDecoder: EntityDecoder[WarehouseStock] = jsonOf[WarehouseStock]
  implicit val WarehouseStockEncoder: EntityEncoder[WarehouseStock] = jsonEncoderOf[WarehouseStock]
}
