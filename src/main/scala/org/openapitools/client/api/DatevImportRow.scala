package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DatevImportRow._

case class DatevImportRow (
  account: String,
amount: String,
baseAmount: String,
baseCurrency: String,
bookingText: String,
buKey: String,
costCenter1: String,
costCenter2: String,
currency: String,
debitCredit: String,
discount: String,
documentDate: String,
documentField2: String,
documentNumber: String,
euCountryVatId: String,
euTaxRate: String,
exchangeRate: String,
oppositeAccount: String)

object DatevImportRow {
  import DateTimeCodecs._

  implicit val DatevImportRowCodecJson: CodecJson[DatevImportRow] = CodecJson.derive[DatevImportRow]
  implicit val DatevImportRowDecoder: EntityDecoder[DatevImportRow] = jsonOf[DatevImportRow]
  implicit val DatevImportRowEncoder: EntityEncoder[DatevImportRow] = jsonEncoderOf[DatevImportRow]
}
