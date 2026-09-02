package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateSubscriptionRequest._

case class UpdateSubscriptionRequest (
  eventType: Option[String],
isActive: Option[Boolean],
name: Option[String],
secret: Option[String],
url: Option[String])

object UpdateSubscriptionRequest {
  import DateTimeCodecs._

  implicit val UpdateSubscriptionRequestCodecJson: CodecJson[UpdateSubscriptionRequest] = CodecJson.derive[UpdateSubscriptionRequest]
  implicit val UpdateSubscriptionRequestDecoder: EntityDecoder[UpdateSubscriptionRequest] = jsonOf[UpdateSubscriptionRequest]
  implicit val UpdateSubscriptionRequestEncoder: EntityEncoder[UpdateSubscriptionRequest] = jsonEncoderOf[UpdateSubscriptionRequest]
}
