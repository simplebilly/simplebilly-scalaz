package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PrintLabelResponse._

case class PrintLabelResponse (
  labelUrl: Option[String],
message: String,
sscc: Option[String],
success: Boolean,
trackingNumber: Option[String])

object PrintLabelResponse {
  import DateTimeCodecs._

  implicit val PrintLabelResponseCodecJson: CodecJson[PrintLabelResponse] = CodecJson.derive[PrintLabelResponse]
  implicit val PrintLabelResponseDecoder: EntityDecoder[PrintLabelResponse] = jsonOf[PrintLabelResponse]
  implicit val PrintLabelResponseEncoder: EntityEncoder[PrintLabelResponse] = jsonEncoderOf[PrintLabelResponse]
}
