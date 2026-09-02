package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PurchaseOrderStatus._

case class PurchaseOrderStatus (
  
object PurchaseOrderStatus {
  import DateTimeCodecs._

  implicit val PurchaseOrderStatusCodecJson: CodecJson[PurchaseOrderStatus] = CodecJson.derive[PurchaseOrderStatus]
  implicit val PurchaseOrderStatusDecoder: EntityDecoder[PurchaseOrderStatus] = jsonOf[PurchaseOrderStatus]
  implicit val PurchaseOrderStatusEncoder: EntityEncoder[PurchaseOrderStatus] = jsonEncoderOf[PurchaseOrderStatus]
}
