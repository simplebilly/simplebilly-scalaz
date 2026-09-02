package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import LanguageCode._

case class LanguageCode (
  
object LanguageCode {
  import DateTimeCodecs._

  implicit val LanguageCodeCodecJson: CodecJson[LanguageCode] = CodecJson.derive[LanguageCode]
  implicit val LanguageCodeDecoder: EntityDecoder[LanguageCode] = jsonOf[LanguageCode]
  implicit val LanguageCodeEncoder: EntityEncoder[LanguageCode] = jsonEncoderOf[LanguageCode]
}
