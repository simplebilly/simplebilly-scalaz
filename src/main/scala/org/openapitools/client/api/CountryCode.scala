package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CountryCode._

case class CountryCode (
  
object CountryCode {
  import DateTimeCodecs._

  implicit val CountryCodeCodecJson: CodecJson[CountryCode] = CodecJson.derive[CountryCode]
  implicit val CountryCodeDecoder: EntityDecoder[CountryCode] = jsonOf[CountryCode]
  implicit val CountryCodeEncoder: EntityEncoder[CountryCode] = jsonEncoderOf[CountryCode]
}
