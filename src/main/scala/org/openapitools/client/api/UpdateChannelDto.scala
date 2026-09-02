package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateChannelDto._

case class UpdateChannelDto (
  config: Option[AnyType],
isActive: Option[Boolean],
name: Option[String])

object UpdateChannelDto {
  import DateTimeCodecs._

  implicit val UpdateChannelDtoCodecJson: CodecJson[UpdateChannelDto] = CodecJson.derive[UpdateChannelDto]
  implicit val UpdateChannelDtoDecoder: EntityDecoder[UpdateChannelDto] = jsonOf[UpdateChannelDto]
  implicit val UpdateChannelDtoEncoder: EntityEncoder[UpdateChannelDto] = jsonEncoderOf[UpdateChannelDto]
}
