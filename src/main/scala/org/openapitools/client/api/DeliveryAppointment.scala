package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import DeliveryAppointment._

case class DeliveryAppointment (
  email: String,
notes: Option[String],
phone: Option[String],
requestedDate: LocalDate,
/* One of: requested | confirmed | arrived | cancelled | completed */
  status: DeliveryAppointmentStatus,
supplierName: String,
/* e.g. \"08:00-10:00\" */
  timeSlot: Option[String],
/* References the warehouse entity. */
  warehouseId: String)

object DeliveryAppointment {
  import DateTimeCodecs._

  implicit val DeliveryAppointmentCodecJson: CodecJson[DeliveryAppointment] = CodecJson.derive[DeliveryAppointment]
  implicit val DeliveryAppointmentDecoder: EntityDecoder[DeliveryAppointment] = jsonOf[DeliveryAppointment]
  implicit val DeliveryAppointmentEncoder: EntityEncoder[DeliveryAppointment] = jsonEncoderOf[DeliveryAppointment]
}
