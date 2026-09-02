package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PlausibilityReport._

case class PlausibilityReport (
  checks: List[PlausibilityCheck],
generatedAt: String,
summary: PlausibilitySummary)

object PlausibilityReport {
  import DateTimeCodecs._

  implicit val PlausibilityReportCodecJson: CodecJson[PlausibilityReport] = CodecJson.derive[PlausibilityReport]
  implicit val PlausibilityReportDecoder: EntityDecoder[PlausibilityReport] = jsonOf[PlausibilityReport]
  implicit val PlausibilityReportEncoder: EntityEncoder[PlausibilityReport] = jsonEncoderOf[PlausibilityReport]
}
