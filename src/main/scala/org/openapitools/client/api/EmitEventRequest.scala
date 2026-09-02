package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmitEventRequest._

case class EmitEventRequest (
  eventType: String,
payload: Option[AnyType])

object EmitEventRequest {
  import DateTimeCodecs._

  implicit val EmitEventRequestCodecJson: CodecJson[EmitEventRequest] = CodecJson.derive[EmitEventRequest]
  implicit val EmitEventRequestDecoder: EntityDecoder[EmitEventRequest] = jsonOf[EmitEventRequest]
  implicit val EmitEventRequestEncoder: EntityEncoder[EmitEventRequest] = jsonEncoderOf[EmitEventRequest]
}
