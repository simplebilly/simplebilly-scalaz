package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import AiWorkerConfig._

case class AiWorkerConfig (
  autoReply: Boolean,
createdAt: OffsetDateTime,
id: UUID,
isActive: Boolean,
maxToolCalls: Integer,
model: String,
name: String,
provider: String,
systemPrompt: String,
tenantId: UUID,
triggerOn: List[String],
updatedAt: Option[OffsetDateTime])

object AiWorkerConfig {
  import DateTimeCodecs._

  implicit val AiWorkerConfigCodecJson: CodecJson[AiWorkerConfig] = CodecJson.derive[AiWorkerConfig]
  implicit val AiWorkerConfigDecoder: EntityDecoder[AiWorkerConfig] = jsonOf[AiWorkerConfig]
  implicit val AiWorkerConfigEncoder: EntityEncoder[AiWorkerConfig] = jsonEncoderOf[AiWorkerConfig]
}
