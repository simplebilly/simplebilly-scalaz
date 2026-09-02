package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ServiceJobCreate._

case class ServiceJobCreate (
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

object ServiceJobCreate {
  import DateTimeCodecs._

  implicit val ServiceJobCreateCodecJson: CodecJson[ServiceJobCreate] = CodecJson.derive[ServiceJobCreate]
  implicit val ServiceJobCreateDecoder: EntityDecoder[ServiceJobCreate] = jsonOf[ServiceJobCreate]
  implicit val ServiceJobCreateEncoder: EntityEncoder[ServiceJobCreate] = jsonEncoderOf[ServiceJobCreate]
}
