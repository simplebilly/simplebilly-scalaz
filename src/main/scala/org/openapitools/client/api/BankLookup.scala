package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BankLookup._

case class BankLookup (
  bankName: Option[String],
bic: Option[String],
iban: String,
nextgenpsd2Url: Option[String],
psd2Supported: Boolean)

object BankLookup {
  import DateTimeCodecs._

  implicit val BankLookupCodecJson: CodecJson[BankLookup] = CodecJson.derive[BankLookup]
  implicit val BankLookupDecoder: EntityDecoder[BankLookup] = jsonOf[BankLookup]
  implicit val BankLookupEncoder: EntityEncoder[BankLookup] = jsonEncoderOf[BankLookup]
}
