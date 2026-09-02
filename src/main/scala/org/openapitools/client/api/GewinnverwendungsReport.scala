package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GewinnverwendungsReport._

case class GewinnverwendungsReport (
  /* Bilanzgewinn nach Einstellung (§ 174 AktG, Beschluss der HV). */
  bilanzgewinn: String,
gesetzlicheRuecklageBestand: String,
/* Deckel: 10 % des Grundkapitals (§ 150 Abs. 2 AktG). */
  gesetzlicheRuecklageCap: String,
/* Rücklage nach Einstellung. */
  gesetzlicheRuecklageNach: String,
/* Vorgeschlagene Einstellung in die gesetzliche Rücklage (§ 150 Abs. 2 AktG). */
  gesetzlicheRuecklageSoll: String,
gezeichnetesKapital: String,
jahresueberschuss: String,
year: Integer,
zeilen: List[GewinnverwendungsZeile])

object GewinnverwendungsReport {
  import DateTimeCodecs._

  implicit val GewinnverwendungsReportCodecJson: CodecJson[GewinnverwendungsReport] = CodecJson.derive[GewinnverwendungsReport]
  implicit val GewinnverwendungsReportDecoder: EntityDecoder[GewinnverwendungsReport] = jsonOf[GewinnverwendungsReport]
  implicit val GewinnverwendungsReportEncoder: EntityEncoder[GewinnverwendungsReport] = jsonEncoderOf[GewinnverwendungsReport]
}
