package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import VatSummary._

case class VatSummary (
  inputTaxItems: List[VatItem],
outputTaxItems: List[VatItem],
totalInputTax: String,
totalOutputTax: String,
vatDue: String)

object VatSummary {
  import DateTimeCodecs._

  implicit val VatSummaryCodecJson: CodecJson[VatSummary] = CodecJson.derive[VatSummary]
  implicit val VatSummaryDecoder: EntityDecoder[VatSummary] = jsonOf[VatSummary]
  implicit val VatSummaryEncoder: EntityEncoder[VatSummary] = jsonEncoderOf[VatSummary]
}
