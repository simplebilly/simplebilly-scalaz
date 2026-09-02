package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import EmissionTarget._

case class EmissionTarget (
  baseValue: String,
/* tCO2e in the base year (actuals). */
  baseYear: Integer,
/* Transition-plan narrative (ESRS E1-1 light), may be empty. */
  description: String,
/* \"total\" | \"1\" | \"2\" | \"3\". */
  scope: EmissionTargetScope,
targetValue: String,
/* tCO2e target for the target year. */
  targetYear: Integer,
updatedAt: Option[OffsetDateTime])

object EmissionTarget {
  import DateTimeCodecs._

  implicit val EmissionTargetCodecJson: CodecJson[EmissionTarget] = CodecJson.derive[EmissionTarget]
  implicit val EmissionTargetDecoder: EntityDecoder[EmissionTarget] = jsonOf[EmissionTarget]
  implicit val EmissionTargetEncoder: EntityEncoder[EmissionTarget] = jsonEncoderOf[EmissionTarget]
}
