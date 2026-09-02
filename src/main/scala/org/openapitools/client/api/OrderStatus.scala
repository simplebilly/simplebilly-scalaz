package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OrderStatus._

case class OrderStatus (
  
object OrderStatus {
  import DateTimeCodecs._

  implicit val OrderStatusCodecJson: CodecJson[OrderStatus] = CodecJson.derive[OrderStatus]
  implicit val OrderStatusDecoder: EntityDecoder[OrderStatus] = jsonOf[OrderStatus]
  implicit val OrderStatusEncoder: EntityEncoder[OrderStatus] = jsonEncoderOf[OrderStatus]
}
