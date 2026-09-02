package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CustomerUpdate._

case class CustomerUpdate (
  address: Option[AnyType],
contactPerson: Option[String],
email: Option[String],
externalOrderNumber: Option[String],
name: Option[String],
paymentGracePeriodDays: Option[Integer],
phone: Option[String],
vatId: Option[String])

object CustomerUpdate {
  import DateTimeCodecs._

  implicit val CustomerUpdateCodecJson: CodecJson[CustomerUpdate] = CodecJson.derive[CustomerUpdate]
  implicit val CustomerUpdateDecoder: EntityDecoder[CustomerUpdate] = jsonOf[CustomerUpdate]
  implicit val CustomerUpdateEncoder: EntityEncoder[CustomerUpdate] = jsonEncoderOf[CustomerUpdate]
}
