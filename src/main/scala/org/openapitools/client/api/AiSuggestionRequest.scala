package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import AiSuggestionRequest._

case class AiSuggestionRequest (
  instructions: Option[String],
messageBody: Option[String],
ticketId: UUID)

object AiSuggestionRequest {
  import DateTimeCodecs._

  implicit val AiSuggestionRequestCodecJson: CodecJson[AiSuggestionRequest] = CodecJson.derive[AiSuggestionRequest]
  implicit val AiSuggestionRequestDecoder: EntityDecoder[AiSuggestionRequest] = jsonOf[AiSuggestionRequest]
  implicit val AiSuggestionRequestEncoder: EntityEncoder[AiSuggestionRequest] = jsonEncoderOf[AiSuggestionRequest]
}
