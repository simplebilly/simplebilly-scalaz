package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WebhookSubscription._

case class WebhookSubscription (
  /* Event type to react to (e.g. \"order.created\"); \"*\" = all events. */
  eventType: String,
isActive: Option[Boolean],
/* Human label (e.g. \"Warehouse app\"). */
  name: String,
/* Shared secret for HMAC-SHA256 signature, sent as X-Signature. */
  secret: String,
url: String)

object WebhookSubscription {
  import DateTimeCodecs._

  implicit val WebhookSubscriptionCodecJson: CodecJson[WebhookSubscription] = CodecJson.derive[WebhookSubscription]
  implicit val WebhookSubscriptionDecoder: EntityDecoder[WebhookSubscription] = jsonOf[WebhookSubscription]
  implicit val WebhookSubscriptionEncoder: EntityEncoder[WebhookSubscription] = jsonEncoderOf[WebhookSubscription]
}
