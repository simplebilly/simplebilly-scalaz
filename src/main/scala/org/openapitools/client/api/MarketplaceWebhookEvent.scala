package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MarketplaceWebhookEvent._

case class MarketplaceWebhookEvent (
  /* References the marketplace connection entity. */
  connectionId: String,
eventBody: Option[AnyType],
eventType: String,
headers: Option[AnyType],
platform: String,
processed: Option[Boolean],
processingError: Option[String])

object MarketplaceWebhookEvent {
  import DateTimeCodecs._

  implicit val MarketplaceWebhookEventCodecJson: CodecJson[MarketplaceWebhookEvent] = CodecJson.derive[MarketplaceWebhookEvent]
  implicit val MarketplaceWebhookEventDecoder: EntityDecoder[MarketplaceWebhookEvent] = jsonOf[MarketplaceWebhookEvent]
  implicit val MarketplaceWebhookEventEncoder: EntityEncoder[MarketplaceWebhookEvent] = jsonEncoderOf[MarketplaceWebhookEvent]
}
