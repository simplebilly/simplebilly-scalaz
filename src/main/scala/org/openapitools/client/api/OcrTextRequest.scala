package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OcrTextRequest._

case class OcrTextRequest (
  ocrText: Option[String])

object OcrTextRequest {
  import DateTimeCodecs._

  implicit val OcrTextRequestCodecJson: CodecJson[OcrTextRequest] = CodecJson.derive[OcrTextRequest]
  implicit val OcrTextRequestDecoder: EntityDecoder[OcrTextRequest] = jsonOf[OcrTextRequest]
  implicit val OcrTextRequestEncoder: EntityEncoder[OcrTextRequest] = jsonEncoderOf[OcrTextRequest]
}
