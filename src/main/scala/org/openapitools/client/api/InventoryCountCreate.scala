package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import InventoryCountCreate._

case class InventoryCountCreate (
  countDate: LocalDate,
countNumber: String,
/* JSON array of `{product_id, name, sku, expected_quantity, counted_quantity, bin_location?, batch_number?, variance}`. */
  lineItems: AnyType,
notes: Option[String],
/* One of: draft | counting | reviewed | posted */
  status: InventoryCountStatus,
/* References the warehouse entity. */
  warehouseId: String)

object InventoryCountCreate {
  import DateTimeCodecs._

  implicit val InventoryCountCreateCodecJson: CodecJson[InventoryCountCreate] = CodecJson.derive[InventoryCountCreate]
  implicit val InventoryCountCreateDecoder: EntityDecoder[InventoryCountCreate] = jsonOf[InventoryCountCreate]
  implicit val InventoryCountCreateEncoder: EntityEncoder[InventoryCountCreate] = jsonEncoderOf[InventoryCountCreate]
}
