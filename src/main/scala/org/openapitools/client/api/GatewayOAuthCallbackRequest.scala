package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GatewayOAuthCallbackRequest._

case class GatewayOAuthCallbackRequest (
  code: String,
gatewayType: String,
redirectUri: String,
state: String)

object GatewayOAuthCallbackRequest {
  import DateTimeCodecs._

  implicit val GatewayOAuthCallbackRequestCodecJson: CodecJson[GatewayOAuthCallbackRequest] = CodecJson.derive[GatewayOAuthCallbackRequest]
  implicit val GatewayOAuthCallbackRequestDecoder: EntityDecoder[GatewayOAuthCallbackRequest] = jsonOf[GatewayOAuthCallbackRequest]
  implicit val GatewayOAuthCallbackRequestEncoder: EntityEncoder[GatewayOAuthCallbackRequest] = jsonEncoderOf[GatewayOAuthCallbackRequest]
}
