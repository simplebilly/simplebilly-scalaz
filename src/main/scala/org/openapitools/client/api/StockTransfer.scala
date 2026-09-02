package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import StockTransfer._

case class StockTransfer (
  /* JSON array of `{product_id, name, quantity, batch_number?}`. */
  lineItems: AnyType,
notes: Option[String],
/* References the warehouse entity. */
  sourceWarehouseId: String,
/* One of: draft | completed | cancelled */
  status: StockTransferStatus,
/* References the warehouse entity. */
  targetWarehouseId: String,
transferDate: LocalDate,
transferNumber: String)

object StockTransfer {
  import DateTimeCodecs._

  implicit val StockTransferCodecJson: CodecJson[StockTransfer] = CodecJson.derive[StockTransfer]
  implicit val StockTransferDecoder: EntityDecoder[StockTransfer] = jsonOf[StockTransfer]
  implicit val StockTransferEncoder: EntityEncoder[StockTransfer] = jsonEncoderOf[StockTransfer]
}
