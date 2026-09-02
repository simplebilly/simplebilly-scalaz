package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import SubmitResultResponse._

case class SubmitResultResponse (
  certificateId: Option[String],
completionId: UUID,
passScore: Integer,
passed: Boolean,
score: Integer,
validUntil: Option[OffsetDateTime])

object SubmitResultResponse {
  import DateTimeCodecs._

  implicit val SubmitResultResponseCodecJson: CodecJson[SubmitResultResponse] = CodecJson.derive[SubmitResultResponse]
  implicit val SubmitResultResponseDecoder: EntityDecoder[SubmitResultResponse] = jsonOf[SubmitResultResponse]
  implicit val SubmitResultResponseEncoder: EntityEncoder[SubmitResultResponse] = jsonEncoderOf[SubmitResultResponse]
}
