package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PurchaseOrderStatusUpdate._

case class PurchaseOrderStatusUpdate (
  status: String)

object PurchaseOrderStatusUpdate {
  import DateTimeCodecs._

  implicit val PurchaseOrderStatusUpdateCodecJson: CodecJson[PurchaseOrderStatusUpdate] = CodecJson.derive[PurchaseOrderStatusUpdate]
  implicit val PurchaseOrderStatusUpdateDecoder: EntityDecoder[PurchaseOrderStatusUpdate] = jsonOf[PurchaseOrderStatusUpdate]
  implicit val PurchaseOrderStatusUpdateEncoder: EntityEncoder[PurchaseOrderStatusUpdate] = jsonEncoderOf[PurchaseOrderStatusUpdate]
}
