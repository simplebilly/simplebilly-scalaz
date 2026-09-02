package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import TaxRateCreate._

case class TaxRateCreate (
  /* ISO 3166-1 alpha-2 country code. */
  countryCode: String,
/* Date this rate took effect; `None` = not date-bound. */
  effectiveFrom: Option[LocalDate],
/* Default rate for the country (one per country); fallback for lookups when no dated rate applies. */
  isDefault: Boolean,
/* Human name, e.g. \"VAT\". */
  name: String,
/* Rate in hundredths of a percent: 1900 = 19.00%. */
  ratePercent: Long)

object TaxRateCreate {
  import DateTimeCodecs._

  implicit val TaxRateCreateCodecJson: CodecJson[TaxRateCreate] = CodecJson.derive[TaxRateCreate]
  implicit val TaxRateCreateDecoder: EntityDecoder[TaxRateCreate] = jsonOf[TaxRateCreate]
  implicit val TaxRateCreateEncoder: EntityEncoder[TaxRateCreate] = jsonEncoderOf[TaxRateCreate]
}
