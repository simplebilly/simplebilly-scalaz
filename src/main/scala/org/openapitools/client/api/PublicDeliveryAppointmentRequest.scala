package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import PublicDeliveryAppointmentRequest._

case class PublicDeliveryAppointmentRequest (
  email: String,
notes: Option[String],
requestedDate: LocalDate,
supplierName: String,
timeSlot: Option[String],
/* Warehouse `code` — the supplier does not know the warehouse uuid. */
  warehouseCode: String)

object PublicDeliveryAppointmentRequest {
  import DateTimeCodecs._

  implicit val PublicDeliveryAppointmentRequestCodecJson: CodecJson[PublicDeliveryAppointmentRequest] = CodecJson.derive[PublicDeliveryAppointmentRequest]
  implicit val PublicDeliveryAppointmentRequestDecoder: EntityDecoder[PublicDeliveryAppointmentRequest] = jsonOf[PublicDeliveryAppointmentRequest]
  implicit val PublicDeliveryAppointmentRequestEncoder: EntityEncoder[PublicDeliveryAppointmentRequest] = jsonEncoderOf[PublicDeliveryAppointmentRequest]
}
