package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BilanzReport._

case class BilanzReport (
  aktiva: List[BilanzItem],
balanced: Boolean,
generatedAt: String,
passiva: List[BilanzItem],
period: String,
totalAktiva: String,
totalPassiva: String)

object BilanzReport {
  import DateTimeCodecs._

  implicit val BilanzReportCodecJson: CodecJson[BilanzReport] = CodecJson.derive[BilanzReport]
  implicit val BilanzReportDecoder: EntityDecoder[BilanzReport] = jsonOf[BilanzReport]
  implicit val BilanzReportEncoder: EntityEncoder[BilanzReport] = jsonEncoderOf[BilanzReport]
}
