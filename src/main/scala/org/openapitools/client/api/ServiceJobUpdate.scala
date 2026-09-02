package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ServiceJobUpdate._

case class ServiceJobUpdate (
  /* Street + zip + city of the job location. */
  address: Option[String],
/* Customer email for email notifications. */
  customerEmail: Option[String],
/* References the customer entity. */
  customerId: Option[UUID],
/* Denormalized customer name for quick display. */
  customerName: Option[String],
/* Customer phone for SMS notifications later. */
  customerPhone: Option[String],
/* What work needs to be done. */
  description: Option[String],
/* Estimated time for the job in minutes. */
  estimatedDurationMinutes: Option[Integer],
/* Latitude for map display (OpenStreetMap). */
  lat: Option[Double],
/* Longitude for map display (OpenStreetMap). */
  lng: Option[Double],
notes: Option[String],
/* Dispatch status: \"pending\", \"assigned\", \"en_route\", \"in_progress\", \"completed\", \"cancelled\". */
  status: Option[ServiceJobStatus])

object ServiceJobUpdate {
  import DateTimeCodecs._

  implicit val ServiceJobUpdateCodecJson: CodecJson[ServiceJobUpdate] = CodecJson.derive[ServiceJobUpdate]
  implicit val ServiceJobUpdateDecoder: EntityDecoder[ServiceJobUpdate] = jsonOf[ServiceJobUpdate]
  implicit val ServiceJobUpdateEncoder: EntityEncoder[ServiceJobUpdate] = jsonEncoderOf[ServiceJobUpdate]
}
