package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TrackOrderRequest._

case class TrackOrderRequest (
  email: String,
orderNumber: String)

object TrackOrderRequest {
  import DateTimeCodecs._

  implicit val TrackOrderRequestCodecJson: CodecJson[TrackOrderRequest] = CodecJson.derive[TrackOrderRequest]
  implicit val TrackOrderRequestDecoder: EntityDecoder[TrackOrderRequest] = jsonOf[TrackOrderRequest]
  implicit val TrackOrderRequestEncoder: EntityEncoder[TrackOrderRequest] = jsonEncoderOf[TrackOrderRequest]
}
