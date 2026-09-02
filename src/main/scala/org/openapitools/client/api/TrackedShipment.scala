package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TrackedShipment._

case class TrackedShipment (
  carrier: String,
events: List[TrackingEvent],
labelUrl: Option[String],
status: String,
trackingNumber: Option[String],
trackingUrl: Option[String])

object TrackedShipment {
  import DateTimeCodecs._

  implicit val TrackedShipmentCodecJson: CodecJson[TrackedShipment] = CodecJson.derive[TrackedShipment]
  implicit val TrackedShipmentDecoder: EntityDecoder[TrackedShipment] = jsonOf[TrackedShipment]
  implicit val TrackedShipmentEncoder: EntityEncoder[TrackedShipment] = jsonEncoderOf[TrackedShipment]
}
