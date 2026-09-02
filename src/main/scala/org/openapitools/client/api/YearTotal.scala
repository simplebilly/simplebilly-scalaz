package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import YearTotal._

case class YearTotal (
  tco2e: String,
year: Integer)

object YearTotal {
  import DateTimeCodecs._

  implicit val YearTotalCodecJson: CodecJson[YearTotal] = CodecJson.derive[YearTotal]
  implicit val YearTotalDecoder: EntityDecoder[YearTotal] = jsonOf[YearTotal]
  implicit val YearTotalEncoder: EntityEncoder[YearTotal] = jsonEncoderOf[YearTotal]
}
