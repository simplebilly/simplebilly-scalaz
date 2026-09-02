package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OrderUpdate._

case class OrderUpdate (
  auditLog: Option[AnyType],
currency: Option[String],
/* References the customer entity. */
  customerId: Option[String],
externalReference: Option[String],
invoiceAddress: Option[AnyType],
items: Option[AnyType],
language: Option[LanguageCode],
orderStatus: Option[OrderStatus],
paymentMethod: Option[PaymentMethod],
shippingAddress: Option[AnyType],
shippingCost: Option[String],
shippingMethod: Option[String],
shippingWeight: Option[String],
tags: Option[List[String]],
totalCost: Option[String])

object OrderUpdate {
  import DateTimeCodecs._

  implicit val OrderUpdateCodecJson: CodecJson[OrderUpdate] = CodecJson.derive[OrderUpdate]
  implicit val OrderUpdateDecoder: EntityDecoder[OrderUpdate] = jsonOf[OrderUpdate]
  implicit val OrderUpdateEncoder: EntityEncoder[OrderUpdate] = jsonEncoderOf[OrderUpdate]
}
