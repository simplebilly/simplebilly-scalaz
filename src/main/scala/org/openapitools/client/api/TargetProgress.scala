package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import TargetProgress._

case class TargetProgress (
  baseValue: Double,
baseYear: Integer,
description: String,
id: UUID,
/* Current year's emissions for the scope as % of the target. None when no data. */
  progressPct: Option[Double],
scope: String,
targetValue: Double,
targetYear: Integer)

object TargetProgress {
  import DateTimeCodecs._

  implicit val TargetProgressCodecJson: CodecJson[TargetProgress] = CodecJson.derive[TargetProgress]
  implicit val TargetProgressDecoder: EntityDecoder[TargetProgress] = jsonOf[TargetProgress]
  implicit val TargetProgressEncoder: EntityEncoder[TargetProgress] = jsonEncoderOf[TargetProgress]
}
