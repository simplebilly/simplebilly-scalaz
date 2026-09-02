package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WebhookEvent._

case class WebhookEvent (
  attempts: Option[Integer],
/* source for inbound, target URL for outbound. */
  channel: Option[String],
/* inbound | outbound */
  direction: WebhookDirection,
eventType: String,
lastError: Option[String],
payload: Option[AnyType],
/* accepted | delivered | failed */
  status: Option[WebhookEventStatus])

object WebhookEvent {
  import DateTimeCodecs._

  implicit val WebhookEventCodecJson: CodecJson[WebhookEvent] = CodecJson.derive[WebhookEvent]
  implicit val WebhookEventDecoder: EntityDecoder[WebhookEvent] = jsonOf[WebhookEvent]
  implicit val WebhookEventEncoder: EntityEncoder[WebhookEvent] = jsonEncoderOf[WebhookEvent]
}
