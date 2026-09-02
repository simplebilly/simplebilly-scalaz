package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SendMessageDto._

case class SendMessageDto (
  body: String,
isInternal: Option[Boolean])

object SendMessageDto {
  import DateTimeCodecs._

  implicit val SendMessageDtoCodecJson: CodecJson[SendMessageDto] = CodecJson.derive[SendMessageDto]
  implicit val SendMessageDtoDecoder: EntityDecoder[SendMessageDto] = jsonOf[SendMessageDto]
  implicit val SendMessageDtoEncoder: EntityEncoder[SendMessageDto] = jsonEncoderOf[SendMessageDto]
}
