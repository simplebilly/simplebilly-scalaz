package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CommunicationChannel._

case class CommunicationChannel (
  
object CommunicationChannel {
  import DateTimeCodecs._

  implicit val CommunicationChannelCodecJson: CodecJson[CommunicationChannel] = CodecJson.derive[CommunicationChannel]
  implicit val CommunicationChannelDecoder: EntityDecoder[CommunicationChannel] = jsonOf[CommunicationChannel]
  implicit val CommunicationChannelEncoder: EntityEncoder[CommunicationChannel] = jsonEncoderOf[CommunicationChannel]
}
