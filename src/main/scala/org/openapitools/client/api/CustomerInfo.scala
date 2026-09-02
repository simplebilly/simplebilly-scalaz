package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CustomerInfo._

case class CustomerInfo (
  annualVolume: Integer,
isRegistered: Boolean)

object CustomerInfo {
  import DateTimeCodecs._

  implicit val CustomerInfoCodecJson: CodecJson[CustomerInfo] = CodecJson.derive[CustomerInfo]
  implicit val CustomerInfoDecoder: EntityDecoder[CustomerInfo] = jsonOf[CustomerInfo]
  implicit val CustomerInfoEncoder: EntityEncoder[CustomerInfo] = jsonEncoderOf[CustomerInfo]
}
