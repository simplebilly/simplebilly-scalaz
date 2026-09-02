package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ReturnOrderStatusUpdate._

case class ReturnOrderStatusUpdate (
  status: String)

object ReturnOrderStatusUpdate {
  import DateTimeCodecs._

  implicit val ReturnOrderStatusUpdateCodecJson: CodecJson[ReturnOrderStatusUpdate] = CodecJson.derive[ReturnOrderStatusUpdate]
  implicit val ReturnOrderStatusUpdateDecoder: EntityDecoder[ReturnOrderStatusUpdate] = jsonOf[ReturnOrderStatusUpdate]
  implicit val ReturnOrderStatusUpdateEncoder: EntityEncoder[ReturnOrderStatusUpdate] = jsonEncoderOf[ReturnOrderStatusUpdate]
}
