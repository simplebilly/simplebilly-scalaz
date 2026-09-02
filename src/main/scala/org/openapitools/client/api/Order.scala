package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Order._

case class Order (
  auditLog: Option[AnyType],
currency: String,
/* References the customer entity. */
  customerId: String,
externalReference: Option[String],
invoiceAddress: Option[AnyType],
items: Option[AnyType],
language: Option[LanguageCode],
orderStatus: OrderStatus,
paymentMethod: PaymentMethod,
shippingAddress: Option[AnyType],
shippingCost: String,
shippingMethod: String,
shippingWeight: String,
tags: List[String],
totalCost: String)

object Order {
  import DateTimeCodecs._

  implicit val OrderCodecJson: CodecJson[Order] = CodecJson.derive[Order]
  implicit val OrderDecoder: EntityDecoder[Order] = jsonOf[Order]
  implicit val OrderEncoder: EntityEncoder[Order] = jsonEncoderOf[Order]
}
