package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TrackingInfo._

case class TrackingInfo (
  carrier: String,
estimatedDelivery: Option[String],
events: List[TrackingEvent],
rawResponse: Option[AnyType],
status: String,
trackingNumber: String)

object TrackingInfo {
  import DateTimeCodecs._

  implicit val TrackingInfoCodecJson: CodecJson[TrackingInfo] = CodecJson.derive[TrackingInfo]
  implicit val TrackingInfoDecoder: EntityDecoder[TrackingInfo] = jsonOf[TrackingInfo]
  implicit val TrackingInfoEncoder: EntityEncoder[TrackingInfo] = jsonEncoderOf[TrackingInfo]
}
