package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import SubmitResultDto._

case class SubmitResultDto (
  /* Selected answer indices (required for scored builtin trainings). */
  answers: List[Integer],
assignmentId: Option[UUID],
/* Score 0–100. Only trusted for plugin trainings without server-side scoring; builtin trainings are always re-scored from `answers`. */
  score: Integer,
trainingCode: String)

object SubmitResultDto {
  import DateTimeCodecs._

  implicit val SubmitResultDtoCodecJson: CodecJson[SubmitResultDto] = CodecJson.derive[SubmitResultDto]
  implicit val SubmitResultDtoDecoder: EntityDecoder[SubmitResultDto] = jsonOf[SubmitResultDto]
  implicit val SubmitResultDtoEncoder: EntityEncoder[SubmitResultDto] = jsonEncoderOf[SubmitResultDto]
}
