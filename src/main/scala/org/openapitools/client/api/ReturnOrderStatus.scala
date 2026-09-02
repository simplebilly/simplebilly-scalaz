package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ReturnOrderStatus._

case class ReturnOrderStatus (
  
object ReturnOrderStatus {
  import DateTimeCodecs._

  implicit val ReturnOrderStatusCodecJson: CodecJson[ReturnOrderStatus] = CodecJson.derive[ReturnOrderStatus]
  implicit val ReturnOrderStatusDecoder: EntityDecoder[ReturnOrderStatus] = jsonOf[ReturnOrderStatus]
  implicit val ReturnOrderStatusEncoder: EntityEncoder[ReturnOrderStatus] = jsonEncoderOf[ReturnOrderStatus]
}
