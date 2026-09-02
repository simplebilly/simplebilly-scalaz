package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AiSuggestion._

case class AiSuggestion (
  confidence: Double,
reasoning: String,
suggestedPriority: Option[String],
suggestedReply: String,
suggestedStatus: Option[String],
toolCalls: List[String])

object AiSuggestion {
  import DateTimeCodecs._

  implicit val AiSuggestionCodecJson: CodecJson[AiSuggestion] = CodecJson.derive[AiSuggestion]
  implicit val AiSuggestionDecoder: EntityDecoder[AiSuggestion] = jsonOf[AiSuggestion]
  implicit val AiSuggestionEncoder: EntityEncoder[AiSuggestion] = jsonEncoderOf[AiSuggestion]
}
