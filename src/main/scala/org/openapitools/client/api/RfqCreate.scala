package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import RfqCreate._

case class RfqCreate (
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

object RfqCreate {
  import DateTimeCodecs._

  implicit val RfqCreateCodecJson: CodecJson[RfqCreate] = CodecJson.derive[RfqCreate]
  implicit val RfqCreateDecoder: EntityDecoder[RfqCreate] = jsonOf[RfqCreate]
  implicit val RfqCreateEncoder: EntityEncoder[RfqCreate] = jsonEncoderOf[RfqCreate]
}
