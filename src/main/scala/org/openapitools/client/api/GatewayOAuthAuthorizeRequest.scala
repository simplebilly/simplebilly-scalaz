package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GatewayOAuthAuthorizeRequest._

case class GatewayOAuthAuthorizeRequest (
  gatewayType: String,
redirectUri: String)

object GatewayOAuthAuthorizeRequest {
  import DateTimeCodecs._

  implicit val GatewayOAuthAuthorizeRequestCodecJson: CodecJson[GatewayOAuthAuthorizeRequest] = CodecJson.derive[GatewayOAuthAuthorizeRequest]
  implicit val GatewayOAuthAuthorizeRequestDecoder: EntityDecoder[GatewayOAuthAuthorizeRequest] = jsonOf[GatewayOAuthAuthorizeRequest]
  implicit val GatewayOAuthAuthorizeRequestEncoder: EntityEncoder[GatewayOAuthAuthorizeRequest] = jsonEncoderOf[GatewayOAuthAuthorizeRequest]
}
