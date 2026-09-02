package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import GoodsReceipt._

case class GoodsReceipt (
  grNumber: String,
/* JSON array of `{product_id, name, quantity, batch_number?, expiry_date?, bin_location?}`. */
  lineItems: AnyType,
notes: Option[String],
/* References the purchase order entity. */
  purchaseOrderId: Option[String],
receiptDate: LocalDate,
/* References the supplier entity. */
  supplierContactId: Option[String],
supplierName: Option[String],
/* References the warehouse entity. */
  warehouseId: String)

object GoodsReceipt {
  import DateTimeCodecs._

  implicit val GoodsReceiptCodecJson: CodecJson[GoodsReceipt] = CodecJson.derive[GoodsReceipt]
  implicit val GoodsReceiptDecoder: EntityDecoder[GoodsReceipt] = jsonOf[GoodsReceipt]
  implicit val GoodsReceiptEncoder: EntityEncoder[GoodsReceipt] = jsonEncoderOf[GoodsReceipt]
}
