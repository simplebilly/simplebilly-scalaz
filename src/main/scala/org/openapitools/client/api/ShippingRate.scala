package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ShippingRate._

case class ShippingRate (
  breakdown: Option[String],
carrier: String,
crossBorderSurcharge: Option[String],
/* ISO-2 code of destination country. */
  destinationCountry: String,
estimatedDays: Option[Integer],
/* True when the rate was obtained via an API call rather than calculation. */
  fromApi: Boolean,
insuredValue: Option[String],
islandSurcharge: Option[String],
/* ISO-2 code of origin country. */
  originCountry: String,
rate: String,
service: String,
volumeDiscount: Option[String],
weightKg: Double)

object ShippingRate {
  import DateTimeCodecs._

  implicit val ShippingRateCodecJson: CodecJson[ShippingRate] = CodecJson.derive[ShippingRate]
  implicit val ShippingRateDecoder: EntityDecoder[ShippingRate] = jsonOf[ShippingRate]
  implicit val ShippingRateEncoder: EntityEncoder[ShippingRate] = jsonEncoderOf[ShippingRate]
}
