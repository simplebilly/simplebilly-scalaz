package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DpaAcceptRequest._

case class DpaAcceptRequest (
  acceptedByName: String,
version: String)

object DpaAcceptRequest {
  import DateTimeCodecs._

  implicit val DpaAcceptRequestCodecJson: CodecJson[DpaAcceptRequest] = CodecJson.derive[DpaAcceptRequest]
  implicit val DpaAcceptRequestDecoder: EntityDecoder[DpaAcceptRequest] = jsonOf[DpaAcceptRequest]
  implicit val DpaAcceptRequestEncoder: EntityEncoder[DpaAcceptRequest] = jsonEncoderOf[DpaAcceptRequest]
}
