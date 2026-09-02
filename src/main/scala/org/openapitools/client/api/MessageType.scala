package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MessageType._

case class MessageType (
  
object MessageType {
  import DateTimeCodecs._

  implicit val MessageTypeCodecJson: CodecJson[MessageType] = CodecJson.derive[MessageType]
  implicit val MessageTypeDecoder: EntityDecoder[MessageType] = jsonOf[MessageType]
  implicit val MessageTypeEncoder: EntityEncoder[MessageType] = jsonEncoderOf[MessageType]
}
