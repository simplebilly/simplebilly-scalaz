package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import StilleReport._

case class StilleReport (
  jahresueberschuss: String,
partners: List[StillePartnerZeile],
year: Integer)

object StilleReport {
  import DateTimeCodecs._

  implicit val StilleReportCodecJson: CodecJson[StilleReport] = CodecJson.derive[StilleReport]
  implicit val StilleReportDecoder: EntityDecoder[StilleReport] = jsonOf[StilleReport]
  implicit val StilleReportEncoder: EntityEncoder[StilleReport] = jsonEncoderOf[StilleReport]
}
