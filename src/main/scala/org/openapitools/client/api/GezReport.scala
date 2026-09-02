package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GezReport._

case class GezReport (
  beitragsfreieKfz: Long,
beitragspflichtigeKfz: Long,
betriebsstaetten: List[BetriebsstaettenDetail],
hinweis: String,
hotelzimmerBeitrag: String,
jaehrlicherBeitrag: String,
jahr: Integer,
kfzBeitrag: String,
monatlicherBeitrag: String,
vierteljaehrlicherBeitrag: String)

object GezReport {
  import DateTimeCodecs._

  implicit val GezReportCodecJson: CodecJson[GezReport] = CodecJson.derive[GezReport]
  implicit val GezReportDecoder: EntityDecoder[GezReport] = jsonOf[GezReport]
  implicit val GezReportEncoder: EntityEncoder[GezReport] = jsonEncoderOf[GezReport]
}
