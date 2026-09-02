package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Address._

case class Address (
  city: String,
company: Option[String],
/* ISO 3166-1 alpha-2 country code (e.g. \"DE\", \"PL\", \"FR\"). */
  country: String,
email: Option[String],
name: String,
phone: Option[String],
street: String,
streetNumber: String,
zip: String)

object Address {
  import DateTimeCodecs._

  implicit val AddressCodecJson: CodecJson[Address] = CodecJson.derive[Address]
  implicit val AddressDecoder: EntityDecoder[Address] = jsonOf[Address]
  implicit val AddressEncoder: EntityEncoder[Address] = jsonEncoderOf[Address]
}
