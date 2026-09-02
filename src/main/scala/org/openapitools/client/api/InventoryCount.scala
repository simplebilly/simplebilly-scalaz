package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import InventoryCount._

case class InventoryCount (
  countDate: LocalDate,
countNumber: String,
/* JSON array of `{product_id, name, sku, expected_quantity, counted_quantity, bin_location?, batch_number?, variance}`. */
  lineItems: AnyType,
notes: Option[String],
/* One of: draft | counting | reviewed | posted */
  status: InventoryCountStatus,
/* References the warehouse entity. */
  warehouseId: String)

object InventoryCount {
  import DateTimeCodecs._

  implicit val InventoryCountCodecJson: CodecJson[InventoryCount] = CodecJson.derive[InventoryCount]
  implicit val InventoryCountDecoder: EntityDecoder[InventoryCount] = jsonOf[InventoryCount]
  implicit val InventoryCountEncoder: EntityEncoder[InventoryCount] = jsonEncoderOf[InventoryCount]
}
