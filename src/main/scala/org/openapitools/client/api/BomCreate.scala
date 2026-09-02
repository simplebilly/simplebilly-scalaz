package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import BomCreate._

case class BomCreate (
  /* JSON array of `{product_id, name, quantity, unit, scrap_rate}`. */
  components: Option[AnyType],
description: Option[String],
name: String,
/* Output quantity per production run (defaults to 1). */
  outputQuantity: Option[Long],
/* The finished product this BOM produces. References the product entity. */
  productId: UUID,
/* One of: draft | active | archived */
  status: Option[BomStatus])

object BomCreate {
  import DateTimeCodecs._

  implicit val BomCreateCodecJson: CodecJson[BomCreate] = CodecJson.derive[BomCreate]
  implicit val BomCreateDecoder: EntityDecoder[BomCreate] = jsonOf[BomCreate]
  implicit val BomCreateEncoder: EntityEncoder[BomCreate] = jsonEncoderOf[BomCreate]
}
