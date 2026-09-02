package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OAuthCallbackRequest._

case class OAuthCallbackRequest (
  code: String,
config: Option[AnyType],
connectionId: Option[String],
platform: String,
shopDomain: Option[String],
state: String)

object OAuthCallbackRequest {
  import DateTimeCodecs._

  implicit val OAuthCallbackRequestCodecJson: CodecJson[OAuthCallbackRequest] = CodecJson.derive[OAuthCallbackRequest]
  implicit val OAuthCallbackRequestDecoder: EntityDecoder[OAuthCallbackRequest] = jsonOf[OAuthCallbackRequest]
  implicit val OAuthCallbackRequestEncoder: EntityEncoder[OAuthCallbackRequest] = jsonEncoderOf[OAuthCallbackRequest]
}
