package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GatewayOAuthAuthorizeResponse._

case class GatewayOAuthAuthorizeResponse (
  authorizationUrl: String,
state: String)

object GatewayOAuthAuthorizeResponse {
  import DateTimeCodecs._

  implicit val GatewayOAuthAuthorizeResponseCodecJson: CodecJson[GatewayOAuthAuthorizeResponse] = CodecJson.derive[GatewayOAuthAuthorizeResponse]
  implicit val GatewayOAuthAuthorizeResponseDecoder: EntityDecoder[GatewayOAuthAuthorizeResponse] = jsonOf[GatewayOAuthAuthorizeResponse]
  implicit val GatewayOAuthAuthorizeResponseEncoder: EntityEncoder[GatewayOAuthAuthorizeResponse] = jsonEncoderOf[GatewayOAuthAuthorizeResponse]
}
