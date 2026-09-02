package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import ReturnLogisticsQueueItem._

case class ReturnLogisticsQueueItem (
  /* Days since creation, oldest first. */
  ageDays: Long,
createdAt: OffsetDateTime,
customerName: Option[String],
lineItems: AnyType,
orderNumber: Option[String],
returnNumber: String,
returnOrderId: String,
status: String,
warehouseId: Option[String])

object ReturnLogisticsQueueItem {
  import DateTimeCodecs._

  implicit val ReturnLogisticsQueueItemCodecJson: CodecJson[ReturnLogisticsQueueItem] = CodecJson.derive[ReturnLogisticsQueueItem]
  implicit val ReturnLogisticsQueueItemDecoder: EntityDecoder[ReturnLogisticsQueueItem] = jsonOf[ReturnLogisticsQueueItem]
  implicit val ReturnLogisticsQueueItemEncoder: EntityEncoder[ReturnLogisticsQueueItem] = jsonEncoderOf[ReturnLogisticsQueueItem]
}
