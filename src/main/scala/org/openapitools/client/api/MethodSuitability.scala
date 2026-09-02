package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MethodSuitability._

case class MethodSuitability (
  carrier: String,
rate: Option[ShippingRate],
reasons: List[String],
service: String,
suitable: Boolean)

object MethodSuitability {
  import DateTimeCodecs._

  implicit val MethodSuitabilityCodecJson: CodecJson[MethodSuitability] = CodecJson.derive[MethodSuitability]
  implicit val MethodSuitabilityDecoder: EntityDecoder[MethodSuitability] = jsonOf[MethodSuitability]
  implicit val MethodSuitabilityEncoder: EntityEncoder[MethodSuitability] = jsonEncoderOf[MethodSuitability]
}
