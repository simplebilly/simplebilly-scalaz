package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PayGapReport._

case class PayGapReport (
  byJobTitle: List[JobTitleGap],
diverseCount: Integer,
employeeCount: Integer,
femaleCount: Integer,
maleCount: Integer,
meanGapPct: Double,
medianGapPct: Double,
quartiles: List[QuartileBand])

object PayGapReport {
  import DateTimeCodecs._

  implicit val PayGapReportCodecJson: CodecJson[PayGapReport] = CodecJson.derive[PayGapReport]
  implicit val PayGapReportDecoder: EntityDecoder[PayGapReport] = jsonOf[PayGapReport]
  implicit val PayGapReportEncoder: EntityEncoder[PayGapReport] = jsonEncoderOf[PayGapReport]
}
