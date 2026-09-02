package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CustomerCreate._

case class CustomerCreate (
  address: Option[AnyType],
contactPerson: Option[String],
email: Option[String],
externalOrderNumber: Option[String],
name: String,
paymentGracePeriodDays: Option[Integer],
phone: Option[String],
vatId: Option[String])

object CustomerCreate {
  import DateTimeCodecs._

  implicit val CustomerCreateCodecJson: CodecJson[CustomerCreate] = CodecJson.derive[CustomerCreate]
  implicit val CustomerCreateDecoder: EntityDecoder[CustomerCreate] = jsonOf[CustomerCreate]
  implicit val CustomerCreateEncoder: EntityEncoder[CustomerCreate] = jsonEncoderOf[CustomerCreate]
}
