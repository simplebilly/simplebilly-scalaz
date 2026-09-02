package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import Rfq._

case class Rfq (
  currency: Option[String],
/* JSON array of `{product_id, name, sku, quantity, requested_unit_price?, quoted_unit_price?}`. */
  lineItems: AnyType,
notes: Option[String],
requestedDate: LocalDate,
responseDate: Option[LocalDate],
rfqNumber: String,
/* One of: draft | sent | offer_received | rejected | converted */
  status: RfqStatus,
/* References the supplier entity. */
  supplierContactId: Option[String],
supplierName: Option[String])

object Rfq {
  import DateTimeCodecs._

  implicit val RfqCodecJson: CodecJson[Rfq] = CodecJson.derive[Rfq]
  implicit val RfqDecoder: EntityDecoder[Rfq] = jsonOf[Rfq]
  implicit val RfqEncoder: EntityEncoder[Rfq] = jsonEncoderOf[Rfq]
}
