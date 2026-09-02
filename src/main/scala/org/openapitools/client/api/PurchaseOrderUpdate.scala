package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import PurchaseOrderUpdate._

case class PurchaseOrderUpdate (
  currency: Option[String],
deliveryAddress: Option[AnyType],
expectedDeliveryDate: Option[LocalDate],
/* JSON array of `{product_id, name, quantity, unit_price_net, tax_rate, delivery_date}`. */
  lineItems: Option[AnyType],
notes: Option[String],
orderDate: Option[LocalDate],
poNumber: Option[String],
/* One of: draft | ordered | partially_received | received | cancelled */
  status: Option[PurchaseOrderStatus],
/* References the supplier entity. */
  supplierContactId: Option[String],
supplierName: Option[String],
totalGrossAmount: Option[String],
totalNetAmount: Option[String])

object PurchaseOrderUpdate {
  import DateTimeCodecs._

  implicit val PurchaseOrderUpdateCodecJson: CodecJson[PurchaseOrderUpdate] = CodecJson.derive[PurchaseOrderUpdate]
  implicit val PurchaseOrderUpdateDecoder: EntityDecoder[PurchaseOrderUpdate] = jsonOf[PurchaseOrderUpdate]
  implicit val PurchaseOrderUpdateEncoder: EntityEncoder[PurchaseOrderUpdate] = jsonEncoderOf[PurchaseOrderUpdate]
}
