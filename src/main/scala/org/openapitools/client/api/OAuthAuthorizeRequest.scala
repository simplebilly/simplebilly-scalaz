package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OAuthAuthorizeRequest._

case class OAuthAuthorizeRequest (
  /* Optional platform-specific config (e.g. Shopify `shop_domain`, `api_key`, `api_secret`) needed to build the authorization URL. */
  config: Option[AnyType],
platform: String,
redirectUri: String)

object OAuthAuthorizeRequest {
  import DateTimeCodecs._

  implicit val OAuthAuthorizeRequestCodecJson: CodecJson[OAuthAuthorizeRequest] = CodecJson.derive[OAuthAuthorizeRequest]
  implicit val OAuthAuthorizeRequestDecoder: EntityDecoder[OAuthAuthorizeRequest] = jsonOf[OAuthAuthorizeRequest]
  implicit val OAuthAuthorizeRequestEncoder: EntityEncoder[OAuthAuthorizeRequest] = jsonEncoderOf[OAuthAuthorizeRequest]
}
