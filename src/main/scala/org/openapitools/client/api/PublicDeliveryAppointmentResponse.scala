package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PublicDeliveryAppointmentResponse._

case class PublicDeliveryAppointmentResponse (
  appointmentId: String,
/* Carries the status-check token (email is out of scope for now). */
  confirmationHint: String,
message: String,
status: String)

object PublicDeliveryAppointmentResponse {
  import DateTimeCodecs._

  implicit val PublicDeliveryAppointmentResponseCodecJson: CodecJson[PublicDeliveryAppointmentResponse] = CodecJson.derive[PublicDeliveryAppointmentResponse]
  implicit val PublicDeliveryAppointmentResponseDecoder: EntityDecoder[PublicDeliveryAppointmentResponse] = jsonOf[PublicDeliveryAppointmentResponse]
  implicit val PublicDeliveryAppointmentResponseEncoder: EntityEncoder[PublicDeliveryAppointmentResponse] = jsonEncoderOf[PublicDeliveryAppointmentResponse]
}
