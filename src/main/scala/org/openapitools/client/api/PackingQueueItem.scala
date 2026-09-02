package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PackingQueueItem._

case class PackingQueueItem (
  createdAt: String,
customerId: String,
deliveryNotePrinted: Boolean,
items: AnyType,
itemsCount: Integer,
labelPrinted: Boolean,
orderNumber: String,
orderStatus: String,
shipmentId: Option[String],
shippingAddress: Option[AnyType],
shippingMethod: String,
trackingNumber: Option[String],
videoRecording: Option[String])

object PackingQueueItem {
  import DateTimeCodecs._

  implicit val PackingQueueItemCodecJson: CodecJson[PackingQueueItem] = CodecJson.derive[PackingQueueItem]
  implicit val PackingQueueItemDecoder: EntityDecoder[PackingQueueItem] = jsonOf[PackingQueueItem]
  implicit val PackingQueueItemEncoder: EntityEncoder[PackingQueueItem] = jsonEncoderOf[PackingQueueItem]
}
