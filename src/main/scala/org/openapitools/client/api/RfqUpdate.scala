package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import RfqUpdate._

case class RfqUpdate (
  currency: Option[String],
/* JSON array of `{product_id, name, sku, quantity, requested_unit_price?, quoted_unit_price?}`. */
  lineItems: Option[AnyType],
notes: Option[String],
requestedDate: Option[LocalDate],
responseDate: Option[LocalDate],
rfqNumber: Option[String],
/* One of: draft | sent | offer_received | rejected | converted */
  status: Option[RfqStatus],
/* References the supplier entity. */
  supplierContactId: Option[String],
supplierName: Option[String])

object RfqUpdate {
  import DateTimeCodecs._

  implicit val RfqUpdateCodecJson: CodecJson[RfqUpdate] = CodecJson.derive[RfqUpdate]
  implicit val RfqUpdateDecoder: EntityDecoder[RfqUpdate] = jsonOf[RfqUpdate]
  implicit val RfqUpdateEncoder: EntityEncoder[RfqUpdate] = jsonEncoderOf[RfqUpdate]
}
