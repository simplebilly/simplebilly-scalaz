package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CreateShipmentRequest._

case class CreateShipmentRequest (
  /* Carrier name as configured in shipping settings: `ups` or `dhl`. */
  carrier: String,
service: Option[String],
weightKg: Option[Double])

object CreateShipmentRequest {
  import DateTimeCodecs._

  implicit val CreateShipmentRequestCodecJson: CodecJson[CreateShipmentRequest] = CodecJson.derive[CreateShipmentRequest]
  implicit val CreateShipmentRequestDecoder: EntityDecoder[CreateShipmentRequest] = jsonOf[CreateShipmentRequest]
  implicit val CreateShipmentRequestEncoder: EntityEncoder[CreateShipmentRequest] = jsonEncoderOf[CreateShipmentRequest]
}
