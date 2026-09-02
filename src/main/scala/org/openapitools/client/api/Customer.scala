package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Customer._

case class Customer (
  address: Option[AnyType],
contactPerson: Option[String],
email: Option[String],
externalOrderNumber: Option[String],
name: String,
paymentGracePeriodDays: Option[Integer],
phone: Option[String],
vatId: Option[String])

object Customer {
  import DateTimeCodecs._

  implicit val CustomerCodecJson: CodecJson[Customer] = CodecJson.derive[Customer]
  implicit val CustomerDecoder: EntityDecoder[Customer] = jsonOf[Customer]
  implicit val CustomerEncoder: EntityEncoder[Customer] = jsonEncoderOf[Customer]
}
