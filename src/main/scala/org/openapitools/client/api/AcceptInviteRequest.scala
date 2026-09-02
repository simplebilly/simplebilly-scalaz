package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AcceptInviteRequest._

case class AcceptInviteRequest (
  firstName: String,
lastName: String,
password: String,
/* GDPR consent — rejected unless true. */
  privacyAccepted: Boolean,
token: String)

object AcceptInviteRequest {
  import DateTimeCodecs._

  implicit val AcceptInviteRequestCodecJson: CodecJson[AcceptInviteRequest] = CodecJson.derive[AcceptInviteRequest]
  implicit val AcceptInviteRequestDecoder: EntityDecoder[AcceptInviteRequest] = jsonOf[AcceptInviteRequest]
  implicit val AcceptInviteRequestEncoder: EntityEncoder[AcceptInviteRequest] = jsonEncoderOf[AcceptInviteRequest]
}
