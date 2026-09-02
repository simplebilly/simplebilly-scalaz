package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EventSubscription._

case class EventSubscription (
  callbackUrl: String,
eventType: String,
isActive: Boolean,
subscriptionId: String)

object EventSubscription {
  import DateTimeCodecs._

  implicit val EventSubscriptionCodecJson: CodecJson[EventSubscription] = CodecJson.derive[EventSubscription]
  implicit val EventSubscriptionDecoder: EntityDecoder[EventSubscription] = jsonOf[EventSubscription]
  implicit val EventSubscriptionEncoder: EntityEncoder[EventSubscription] = jsonEncoderOf[EventSubscription]
}
