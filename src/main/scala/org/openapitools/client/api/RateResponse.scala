package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import RateResponse._

case class RateResponse (
  rates: List[ShippingRate])

object RateResponse {
  import DateTimeCodecs._

  implicit val RateResponseCodecJson: CodecJson[RateResponse] = CodecJson.derive[RateResponse]
  implicit val RateResponseDecoder: EntityDecoder[RateResponse] = jsonOf[RateResponse]
  implicit val RateResponseEncoder: EntityEncoder[RateResponse] = jsonEncoderOf[RateResponse]
}
