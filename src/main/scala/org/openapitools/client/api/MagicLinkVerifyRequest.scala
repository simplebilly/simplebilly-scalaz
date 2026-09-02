package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MagicLinkVerifyRequest._

case class MagicLinkVerifyRequest (
  token: String)

object MagicLinkVerifyRequest {
  import DateTimeCodecs._

  implicit val MagicLinkVerifyRequestCodecJson: CodecJson[MagicLinkVerifyRequest] = CodecJson.derive[MagicLinkVerifyRequest]
  implicit val MagicLinkVerifyRequestDecoder: EntityDecoder[MagicLinkVerifyRequest] = jsonOf[MagicLinkVerifyRequest]
  implicit val MagicLinkVerifyRequestEncoder: EntityEncoder[MagicLinkVerifyRequest] = jsonEncoderOf[MagicLinkVerifyRequest]
}
