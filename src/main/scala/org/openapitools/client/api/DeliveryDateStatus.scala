package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DeliveryDateStatus._

case class DeliveryDateStatus (
  
object DeliveryDateStatus {
  import DateTimeCodecs._

  implicit val DeliveryDateStatusCodecJson: CodecJson[DeliveryDateStatus] = CodecJson.derive[DeliveryDateStatus]
  implicit val DeliveryDateStatusDecoder: EntityDecoder[DeliveryDateStatus] = jsonOf[DeliveryDateStatus]
  implicit val DeliveryDateStatusEncoder: EntityEncoder[DeliveryDateStatus] = jsonEncoderOf[DeliveryDateStatus]
}
