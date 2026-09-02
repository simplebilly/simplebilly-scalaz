package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CategoryTotal._

case class CategoryTotal (
  categoryId: String,
sharePct: Double,
tco2e: String)

object CategoryTotal {
  import DateTimeCodecs._

  implicit val CategoryTotalCodecJson: CodecJson[CategoryTotal] = CodecJson.derive[CategoryTotal]
  implicit val CategoryTotalDecoder: EntityDecoder[CategoryTotal] = jsonOf[CategoryTotal]
  implicit val CategoryTotalEncoder: EntityEncoder[CategoryTotal] = jsonEncoderOf[CategoryTotal]
}
