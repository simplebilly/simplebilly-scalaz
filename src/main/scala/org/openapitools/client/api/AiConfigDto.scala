package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AiConfigDto._

case class AiConfigDto (
  autoReply: Option[Boolean],
maxToolCalls: Option[Integer],
model: String,
name: String,
provider: String,
systemPrompt: Option[String],
triggerOn: Option[List[String]])

object AiConfigDto {
  import DateTimeCodecs._

  implicit val AiConfigDtoCodecJson: CodecJson[AiConfigDto] = CodecJson.derive[AiConfigDto]
  implicit val AiConfigDtoDecoder: EntityDecoder[AiConfigDto] = jsonOf[AiConfigDto]
  implicit val AiConfigDtoEncoder: EntityEncoder[AiConfigDto] = jsonEncoderOf[AiConfigDto]
}
