package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import OffenlegungReport._

case class OffenlegungReport (
  /* Fristende (Abschlussstichtag + Frist). */
  deadline: LocalDate,
/* Offenlegungsfrist in Monaten (§ 325 Abs. 4 HGB). */
  deadlineMonths: Integer,
items: List[OffenlegungItem],
/* Annahme über die Kapitalmarktorientierung. */
  kapitalmarktorientiert: Boolean,
note: String,
/* Berichtsjahr (laufendes Kalenderjahr). */
  year: Integer)

object OffenlegungReport {
  import DateTimeCodecs._

  implicit val OffenlegungReportCodecJson: CodecJson[OffenlegungReport] = CodecJson.derive[OffenlegungReport]
  implicit val OffenlegungReportDecoder: EntityDecoder[OffenlegungReport] = jsonOf[OffenlegungReport]
  implicit val OffenlegungReportEncoder: EntityEncoder[OffenlegungReport] = jsonEncoderOf[OffenlegungReport]
}
