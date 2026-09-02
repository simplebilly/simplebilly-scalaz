package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DeliveryAppointmentStatus._

case class DeliveryAppointmentStatus (
  
object DeliveryAppointmentStatus {
  import DateTimeCodecs._

  implicit val DeliveryAppointmentStatusCodecJson: CodecJson[DeliveryAppointmentStatus] = CodecJson.derive[DeliveryAppointmentStatus]
  implicit val DeliveryAppointmentStatusDecoder: EntityDecoder[DeliveryAppointmentStatus] = jsonOf[DeliveryAppointmentStatus]
  implicit val DeliveryAppointmentStatusEncoder: EntityEncoder[DeliveryAppointmentStatus] = jsonEncoderOf[DeliveryAppointmentStatus]
}
