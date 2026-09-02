package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MessageDirection._

case class MessageDirection (
  
object MessageDirection {
  import DateTimeCodecs._

  implicit val MessageDirectionCodecJson: CodecJson[MessageDirection] = CodecJson.derive[MessageDirection]
  implicit val MessageDirectionDecoder: EntityDecoder[MessageDirection] = jsonOf[MessageDirection]
  implicit val MessageDirectionEncoder: EntityEncoder[MessageDirection] = jsonEncoderOf[MessageDirection]
}
