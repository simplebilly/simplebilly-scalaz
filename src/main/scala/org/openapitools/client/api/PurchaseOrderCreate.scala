package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import PurchaseOrderCreate._

case class PurchaseOrderCreate (
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

object PurchaseOrderCreate {
  import DateTimeCodecs._

  implicit val PurchaseOrderCreateCodecJson: CodecJson[PurchaseOrderCreate] = CodecJson.derive[PurchaseOrderCreate]
  implicit val PurchaseOrderCreateDecoder: EntityDecoder[PurchaseOrderCreate] = jsonOf[PurchaseOrderCreate]
  implicit val PurchaseOrderCreateEncoder: EntityEncoder[PurchaseOrderCreate] = jsonEncoderOf[PurchaseOrderCreate]
}
