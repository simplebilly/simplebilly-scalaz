package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OAuthAuthorizeResponse._

case class OAuthAuthorizeResponse (
  authorizationUrl: String,
state: String)

object OAuthAuthorizeResponse {
  import DateTimeCodecs._

  implicit val OAuthAuthorizeResponseCodecJson: CodecJson[OAuthAuthorizeResponse] = CodecJson.derive[OAuthAuthorizeResponse]
  implicit val OAuthAuthorizeResponseDecoder: EntityDecoder[OAuthAuthorizeResponse] = jsonOf[OAuthAuthorizeResponse]
  implicit val OAuthAuthorizeResponseEncoder: EntityEncoder[OAuthAuthorizeResponse] = jsonEncoderOf[OAuthAuthorizeResponse]
}
