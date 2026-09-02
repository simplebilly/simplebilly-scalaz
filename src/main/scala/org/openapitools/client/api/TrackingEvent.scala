package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TrackingEvent._

case class TrackingEvent (
  date: String,
description: String,
location: String,
status: String)

object TrackingEvent {
  import DateTimeCodecs._

  implicit val TrackingEventCodecJson: CodecJson[TrackingEvent] = CodecJson.derive[TrackingEvent]
  implicit val TrackingEventDecoder: EntityDecoder[TrackingEvent] = jsonOf[TrackingEvent]
  implicit val TrackingEventEncoder: EntityEncoder[TrackingEvent] = jsonEncoderOf[TrackingEvent]
}
