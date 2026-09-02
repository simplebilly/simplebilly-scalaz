package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CommunicationDirection._

case class CommunicationDirection (
  
object CommunicationDirection {
  import DateTimeCodecs._

  implicit val CommunicationDirectionCodecJson: CodecJson[CommunicationDirection] = CodecJson.derive[CommunicationDirection]
  implicit val CommunicationDirectionDecoder: EntityDecoder[CommunicationDirection] = jsonOf[CommunicationDirection]
  implicit val CommunicationDirectionEncoder: EntityEncoder[CommunicationDirection] = jsonEncoderOf[CommunicationDirection]
}
