package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PackingCompleteRequest._

case class PackingCompleteRequest (
  notes: Option[String],
orderNumber: String,
shipmentId: Option[String],
videoUrl: Option[String])

object PackingCompleteRequest {
  import DateTimeCodecs._

  implicit val PackingCompleteRequestCodecJson: CodecJson[PackingCompleteRequest] = CodecJson.derive[PackingCompleteRequest]
  implicit val PackingCompleteRequestDecoder: EntityDecoder[PackingCompleteRequest] = jsonOf[PackingCompleteRequest]
  implicit val PackingCompleteRequestEncoder: EntityEncoder[PackingCompleteRequest] = jsonEncoderOf[PackingCompleteRequest]
}
