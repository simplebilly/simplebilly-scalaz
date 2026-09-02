package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DatevBookingPreview._

case class DatevBookingPreview (
  accountNumber: String,
debitCredit: String,
documentDate: String,
documentText: String,
netAmount: String,
oppositeAccount: String,
taxAmount: Option[String],
taxRate: Option[String])

object DatevBookingPreview {
  import DateTimeCodecs._

  implicit val DatevBookingPreviewCodecJson: CodecJson[DatevBookingPreview] = CodecJson.derive[DatevBookingPreview]
  implicit val DatevBookingPreviewDecoder: EntityDecoder[DatevBookingPreview] = jsonOf[DatevBookingPreview]
  implicit val DatevBookingPreviewEncoder: EntityEncoder[DatevBookingPreview] = jsonEncoderOf[DatevBookingPreview]
}
