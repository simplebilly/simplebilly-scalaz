package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import DeliveryDateUpdate._

case class DeliveryDateUpdate (
  /* References the customer entity. */
  customerId: Option[String],
/* Date actually delivered (set on fulfillment). */
  fulfilledDate: Option[LocalDate],
note: Option[String],
/* Sales order number (`order.order_number`). */
  orderNumber: Option[String],
/* Original date promised before rescheduling. */
  originalDate: Option[LocalDate],
/* Product line item this date applies to, if per-item. References the product entity. */
  productId: Option[String],
/* Date promised to the customer. */
  promisedDate: Option[LocalDate],
/* One of: promised | confirmed | rescheduled | fulfilled | late | cancelled */
  status: Option[DeliveryDateStatus])

object DeliveryDateUpdate {
  import DateTimeCodecs._

  implicit val DeliveryDateUpdateCodecJson: CodecJson[DeliveryDateUpdate] = CodecJson.derive[DeliveryDateUpdate]
  implicit val DeliveryDateUpdateDecoder: EntityDecoder[DeliveryDateUpdate] = jsonOf[DeliveryDateUpdate]
  implicit val DeliveryDateUpdateEncoder: EntityEncoder[DeliveryDateUpdate] = jsonEncoderOf[DeliveryDateUpdate]
}
