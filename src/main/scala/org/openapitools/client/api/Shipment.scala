package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import Shipment._

case class Shipment (
  deliveredAt: Option[OffsetDateTime],
labelUrl: Option[String],
lineItemsShipment: Option[AnyType],
/* References the order entity. */
  orderId: String,
recipientAddress: Option[AnyType],
shipmentDate: LocalDate,
shippingCarrier: String,
shippingCost: Option[String],
shippingMethod: Option[String],
signedBy: Option[String],
status: String,
/* Latest carrier tracking events (from the live tracking API). */
  trackingEvents: Option[AnyType],
trackingNumber: Option[String],
trackingUrl: Option[String],
weightKg: Option[Double])

object Shipment {
  import DateTimeCodecs._

  implicit val ShipmentCodecJson: CodecJson[Shipment] = CodecJson.derive[Shipment]
  implicit val ShipmentDecoder: EntityDecoder[Shipment] = jsonOf[Shipment]
  implicit val ShipmentEncoder: EntityEncoder[Shipment] = jsonEncoderOf[Shipment]
}
