package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CreateSubscriptionRequest._

case class CreateSubscriptionRequest (
  eventType: String,
isActive: Option[Boolean],
name: String,
secret: Option[String],
url: String)

object CreateSubscriptionRequest {
  import DateTimeCodecs._

  implicit val CreateSubscriptionRequestCodecJson: CodecJson[CreateSubscriptionRequest] = CodecJson.derive[CreateSubscriptionRequest]
  implicit val CreateSubscriptionRequestDecoder: EntityDecoder[CreateSubscriptionRequest] = jsonOf[CreateSubscriptionRequest]
  implicit val CreateSubscriptionRequestEncoder: EntityEncoder[CreateSubscriptionRequest] = jsonEncoderOf[CreateSubscriptionRequest]
}
