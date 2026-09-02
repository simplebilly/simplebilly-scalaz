package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CreateChannelDto._

case class CreateChannelDto (
  channelType: String,
config: AnyType,
name: String)

object CreateChannelDto {
  import DateTimeCodecs._

  implicit val CreateChannelDtoCodecJson: CodecJson[CreateChannelDto] = CodecJson.derive[CreateChannelDto]
  implicit val CreateChannelDtoDecoder: EntityDecoder[CreateChannelDto] = jsonOf[CreateChannelDto]
  implicit val CreateChannelDtoEncoder: EntityEncoder[CreateChannelDto] = jsonEncoderOf[CreateChannelDto]
}
