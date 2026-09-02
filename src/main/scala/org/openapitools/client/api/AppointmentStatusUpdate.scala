package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AppointmentStatusUpdate._

case class AppointmentStatusUpdate (
  status: String)

object AppointmentStatusUpdate {
  import DateTimeCodecs._

  implicit val AppointmentStatusUpdateCodecJson: CodecJson[AppointmentStatusUpdate] = CodecJson.derive[AppointmentStatusUpdate]
  implicit val AppointmentStatusUpdateDecoder: EntityDecoder[AppointmentStatusUpdate] = jsonOf[AppointmentStatusUpdate]
  implicit val AppointmentStatusUpdateEncoder: EntityEncoder[AppointmentStatusUpdate] = jsonEncoderOf[AppointmentStatusUpdate]
}
