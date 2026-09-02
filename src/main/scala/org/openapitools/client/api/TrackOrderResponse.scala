package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TrackOrderResponse._

case class TrackOrderResponse (
  orderNumber: String,
orderStatus: String,
shipments: List[TrackedShipment])

object TrackOrderResponse {
  import DateTimeCodecs._

  implicit val TrackOrderResponseCodecJson: CodecJson[TrackOrderResponse] = CodecJson.derive[TrackOrderResponse]
  implicit val TrackOrderResponseDecoder: EntityDecoder[TrackOrderResponse] = jsonOf[TrackOrderResponse]
  implicit val TrackOrderResponseEncoder: EntityEncoder[TrackOrderResponse] = jsonEncoderOf[TrackOrderResponse]
}
