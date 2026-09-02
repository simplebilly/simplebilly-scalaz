package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import QuartileBand._

case class QuartileBand (
  femaleSharePct: Double,
hourlyMedian: String,
maleSharePct: Double,
quartile: String)

object QuartileBand {
  import DateTimeCodecs._

  implicit val QuartileBandCodecJson: CodecJson[QuartileBand] = CodecJson.derive[QuartileBand]
  implicit val QuartileBandDecoder: EntityDecoder[QuartileBand] = jsonOf[QuartileBand]
  implicit val QuartileBandEncoder: EntityEncoder[QuartileBand] = jsonEncoderOf[QuartileBand]
}
