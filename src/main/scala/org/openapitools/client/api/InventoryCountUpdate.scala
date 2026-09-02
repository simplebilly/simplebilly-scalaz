package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import InventoryCountUpdate._

case class InventoryCountUpdate (
  countDate: Option[LocalDate],
countNumber: Option[String],
/* JSON array of `{product_id, name, sku, expected_quantity, counted_quantity, bin_location?, batch_number?, variance}`. */
  lineItems: Option[AnyType],
notes: Option[String],
/* One of: draft | counting | reviewed | posted */
  status: Option[InventoryCountStatus],
/* References the warehouse entity. */
  warehouseId: Option[String])

object InventoryCountUpdate {
  import DateTimeCodecs._

  implicit val InventoryCountUpdateCodecJson: CodecJson[InventoryCountUpdate] = CodecJson.derive[InventoryCountUpdate]
  implicit val InventoryCountUpdateDecoder: EntityDecoder[InventoryCountUpdate] = jsonOf[InventoryCountUpdate]
  implicit val InventoryCountUpdateEncoder: EntityEncoder[InventoryCountUpdate] = jsonEncoderOf[InventoryCountUpdate]
}
