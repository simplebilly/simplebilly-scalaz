package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WebhookEventStatus._

case class WebhookEventStatus (
  
object WebhookEventStatus {
  import DateTimeCodecs._

  implicit val WebhookEventStatusCodecJson: CodecJson[WebhookEventStatus] = CodecJson.derive[WebhookEventStatus]
  implicit val WebhookEventStatusDecoder: EntityDecoder[WebhookEventStatus] = jsonOf[WebhookEventStatus]
  implicit val WebhookEventStatusEncoder: EntityEncoder[WebhookEventStatus] = jsonEncoderOf[WebhookEventStatus]
}
