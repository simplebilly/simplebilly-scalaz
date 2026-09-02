package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InviteRequest._

case class InviteRequest (
  email: String)

object InviteRequest {
  import DateTimeCodecs._

  implicit val InviteRequestCodecJson: CodecJson[InviteRequest] = CodecJson.derive[InviteRequest]
  implicit val InviteRequestDecoder: EntityDecoder[InviteRequest] = jsonOf[InviteRequest]
  implicit val InviteRequestEncoder: EntityEncoder[InviteRequest] = jsonEncoderOf[InviteRequest]
}
