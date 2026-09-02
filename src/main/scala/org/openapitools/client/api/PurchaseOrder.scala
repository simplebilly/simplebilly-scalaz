package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import PurchaseOrder._

case class PurchaseOrder (
  currency: Option[String],
deliveryAddress: Option[AnyType],
expectedDeliveryDate: Option[LocalDate],
/* JSON array of `{product_id, name, quantity, unit_price_net, tax_rate, delivery_date}`. */
  lineItems: Option[AnyType],
notes: Option[String],
orderDate: LocalDate,
poNumber: String,
/* One of: draft | ordered | partially_received | received | cancelled */
  status: PurchaseOrderStatus,
/* References the supplier entity. */
  supplierContactId: Option[String],
supplierName: Option[String],
totalGrossAmount: Option[String],
totalNetAmount: Option[String])

object PurchaseOrder {
  import DateTimeCodecs._

  implicit val PurchaseOrderCodecJson: CodecJson[PurchaseOrder] = CodecJson.derive[PurchaseOrder]
  implicit val PurchaseOrderDecoder: EntityDecoder[PurchaseOrder] = jsonOf[PurchaseOrder]
  implicit val PurchaseOrderEncoder: EntityEncoder[PurchaseOrder] = jsonEncoderOf[PurchaseOrder]
}
