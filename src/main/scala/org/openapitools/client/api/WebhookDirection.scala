package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WebhookDirection._

case class WebhookDirection (
  
object WebhookDirection {
  import DateTimeCodecs._

  implicit val WebhookDirectionCodecJson: CodecJson[WebhookDirection] = CodecJson.derive[WebhookDirection]
  implicit val WebhookDirectionDecoder: EntityDecoder[WebhookDirection] = jsonOf[WebhookDirection]
  implicit val WebhookDirectionEncoder: EntityEncoder[WebhookDirection] = jsonEncoderOf[WebhookDirection]
}
