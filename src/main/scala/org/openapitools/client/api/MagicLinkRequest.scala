package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MagicLinkRequest._

case class MagicLinkRequest (
  email: String)

object MagicLinkRequest {
  import DateTimeCodecs._

  implicit val MagicLinkRequestCodecJson: CodecJson[MagicLinkRequest] = CodecJson.derive[MagicLinkRequest]
  implicit val MagicLinkRequestDecoder: EntityDecoder[MagicLinkRequest] = jsonOf[MagicLinkRequest]
  implicit val MagicLinkRequestEncoder: EntityEncoder[MagicLinkRequest] = jsonEncoderOf[MagicLinkRequest]
}
