package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ShippingThresholdUpdate._

case class ShippingThresholdUpdate (
  isActive: Option[Boolean],
/* Optional ceiling for the deliverable quantity. */
  maxSellable: Option[Long],
name: Option[String],
notes: Option[String],
/* None = applies to all products. References the product entity. */
  productId: Option[UUID],
/* Buffer of stock that must not be sold. */
  reserveStock: Option[Long],
/* None = applies to all warehouses. References the warehouse entity. */
  warehouseId: Option[String])

object ShippingThresholdUpdate {
  import DateTimeCodecs._

  implicit val ShippingThresholdUpdateCodecJson: CodecJson[ShippingThresholdUpdate] = CodecJson.derive[ShippingThresholdUpdate]
  implicit val ShippingThresholdUpdateDecoder: EntityDecoder[ShippingThresholdUpdate] = jsonOf[ShippingThresholdUpdate]
  implicit val ShippingThresholdUpdateEncoder: EntityEncoder[ShippingThresholdUpdate] = jsonEncoderOf[ShippingThresholdUpdate]
}
