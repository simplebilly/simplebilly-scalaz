package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import SupportChannel._

case class SupportChannel (
  channelType: SupportChannelType,
config: AnyType,
createdAt: OffsetDateTime,
isActive: Boolean,
name: String,
tenantId: UUID,
updatedAt: Option[OffsetDateTime])

object SupportChannel {
  import DateTimeCodecs._

  implicit val SupportChannelCodecJson: CodecJson[SupportChannel] = CodecJson.derive[SupportChannel]
  implicit val SupportChannelDecoder: EntityDecoder[SupportChannel] = jsonOf[SupportChannel]
  implicit val SupportChannelEncoder: EntityEncoder[SupportChannel] = jsonEncoderOf[SupportChannel]
}
