package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DeliveryDateStatusUpdate._

case class DeliveryDateStatusUpdate (
  status: String)

object DeliveryDateStatusUpdate {
  import DateTimeCodecs._

  implicit val DeliveryDateStatusUpdateCodecJson: CodecJson[DeliveryDateStatusUpdate] = CodecJson.derive[DeliveryDateStatusUpdate]
  implicit val DeliveryDateStatusUpdateDecoder: EntityDecoder[DeliveryDateStatusUpdate] = jsonOf[DeliveryDateStatusUpdate]
  implicit val DeliveryDateStatusUpdateEncoder: EntityEncoder[DeliveryDateStatusUpdate] = jsonEncoderOf[DeliveryDateStatusUpdate]
}
