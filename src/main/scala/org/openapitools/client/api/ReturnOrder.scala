package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ReturnOrder._

case class ReturnOrder (
  /* References the contact entity. */
  customerContactId: Option[String],
customerName: Option[String],
/* JSON array of `{product_id, name, quantity, condition, restock, batch_number?}`. */
  lineItems: Option[AnyType],
notes: Option[String],
/* References the order entity. */
  orderId: Option[String],
orderNumber: Option[String],
returnNumber: String,
returnReason: Option[String],
/* One of: requested | received | inspected | restocked | closed */
  status: ReturnOrderStatus,
/* Warehouse into which restockable items are returned. References the warehouse entity. */
  warehouseId: Option[String])

object ReturnOrder {
  import DateTimeCodecs._

  implicit val ReturnOrderCodecJson: CodecJson[ReturnOrder] = CodecJson.derive[ReturnOrder]
  implicit val ReturnOrderDecoder: EntityDecoder[ReturnOrder] = jsonOf[ReturnOrder]
  implicit val ReturnOrderEncoder: EntityEncoder[ReturnOrder] = jsonEncoderOf[ReturnOrder]
}
