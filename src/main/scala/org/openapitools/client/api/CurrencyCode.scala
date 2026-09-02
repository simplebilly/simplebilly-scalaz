package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CurrencyCode._

case class CurrencyCode (
  
object CurrencyCode {
  import DateTimeCodecs._

  implicit val CurrencyCodeCodecJson: CodecJson[CurrencyCode] = CodecJson.derive[CurrencyCode]
  implicit val CurrencyCodeDecoder: EntityDecoder[CurrencyCode] = jsonOf[CurrencyCode]
  implicit val CurrencyCodeEncoder: EntityEncoder[CurrencyCode] = jsonEncoderOf[CurrencyCode]
}
