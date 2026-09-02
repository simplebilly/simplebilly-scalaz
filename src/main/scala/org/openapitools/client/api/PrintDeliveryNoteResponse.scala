package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PrintDeliveryNoteResponse._

case class PrintDeliveryNoteResponse (
  message: String,
pdfUrl: Option[String],
success: Boolean)

object PrintDeliveryNoteResponse {
  import DateTimeCodecs._

  implicit val PrintDeliveryNoteResponseCodecJson: CodecJson[PrintDeliveryNoteResponse] = CodecJson.derive[PrintDeliveryNoteResponse]
  implicit val PrintDeliveryNoteResponseDecoder: EntityDecoder[PrintDeliveryNoteResponse] = jsonOf[PrintDeliveryNoteResponse]
  implicit val PrintDeliveryNoteResponseEncoder: EntityEncoder[PrintDeliveryNoteResponse] = jsonEncoderOf[PrintDeliveryNoteResponse]
}
