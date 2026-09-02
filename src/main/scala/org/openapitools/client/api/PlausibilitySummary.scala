package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PlausibilitySummary._

case class PlausibilitySummary (
  errors: Integer,
overallStatus: CheckStatus,
passed: Integer,
totalChecks: Integer,
warnings: Integer)

object PlausibilitySummary {
  import DateTimeCodecs._

  implicit val PlausibilitySummaryCodecJson: CodecJson[PlausibilitySummary] = CodecJson.derive[PlausibilitySummary]
  implicit val PlausibilitySummaryDecoder: EntityDecoder[PlausibilitySummary] = jsonOf[PlausibilitySummary]
  implicit val PlausibilitySummaryEncoder: EntityEncoder[PlausibilitySummary] = jsonEncoderOf[PlausibilitySummary]
}
