package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ShipmentStatusUpdate._

case class ShipmentStatusUpdate (
  deliveredAt: Option[String],
signedBy: Option[String],
status: String,
trackingNumber: Option[String])

object ShipmentStatusUpdate {
  import DateTimeCodecs._

  implicit val ShipmentStatusUpdateCodecJson: CodecJson[ShipmentStatusUpdate] = CodecJson.derive[ShipmentStatusUpdate]
  implicit val ShipmentStatusUpdateDecoder: EntityDecoder[ShipmentStatusUpdate] = jsonOf[ShipmentStatusUpdate]
  implicit val ShipmentStatusUpdateEncoder: EntityEncoder[ShipmentStatusUpdate] = jsonEncoderOf[ShipmentStatusUpdate]
}
