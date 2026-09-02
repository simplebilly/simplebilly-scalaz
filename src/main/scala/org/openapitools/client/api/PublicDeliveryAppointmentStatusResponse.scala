package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import PublicDeliveryAppointmentStatusResponse._

case class PublicDeliveryAppointmentStatusResponse (
  appointmentId: String,
requestedDate: LocalDate,
status: String,
timeSlot: Option[String],
warehouseName: String)

object PublicDeliveryAppointmentStatusResponse {
  import DateTimeCodecs._

  implicit val PublicDeliveryAppointmentStatusResponseCodecJson: CodecJson[PublicDeliveryAppointmentStatusResponse] = CodecJson.derive[PublicDeliveryAppointmentStatusResponse]
  implicit val PublicDeliveryAppointmentStatusResponseDecoder: EntityDecoder[PublicDeliveryAppointmentStatusResponse] = jsonOf[PublicDeliveryAppointmentStatusResponse]
  implicit val PublicDeliveryAppointmentStatusResponseEncoder: EntityEncoder[PublicDeliveryAppointmentStatusResponse] = jsonEncoderOf[PublicDeliveryAppointmentStatusResponse]
}
