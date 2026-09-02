package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ShippingThresholdCreate._

case class ShippingThresholdCreate (
  isActive: Option[Boolean],
/* Optional ceiling for the deliverable quantity. */
  maxSellable: Option[Long],
name: String,
notes: Option[String],
/* None = applies to all products. References the product entity. */
  productId: Option[UUID],
/* Buffer of stock that must not be sold. */
  reserveStock: Option[Long],
/* None = applies to all warehouses. References the warehouse entity. */
  warehouseId: Option[String])

object ShippingThresholdCreate {
  import DateTimeCodecs._

  implicit val ShippingThresholdCreateCodecJson: CodecJson[ShippingThresholdCreate] = CodecJson.derive[ShippingThresholdCreate]
  implicit val ShippingThresholdCreateDecoder: EntityDecoder[ShippingThresholdCreate] = jsonOf[ShippingThresholdCreate]
  implicit val ShippingThresholdCreateEncoder: EntityEncoder[ShippingThresholdCreate] = jsonEncoderOf[ShippingThresholdCreate]
}
