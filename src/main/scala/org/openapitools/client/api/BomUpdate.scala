package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import BomUpdate._

case class BomUpdate (
  /* JSON array of `{product_id, name, quantity, unit, scrap_rate}`. */
  components: Option[AnyType],
description: Option[String],
name: Option[String],
/* Output quantity per production run (defaults to 1). */
  outputQuantity: Option[Long],
/* The finished product this BOM produces. References the product entity. */
  productId: Option[UUID],
/* One of: draft | active | archived */
  status: Option[BomStatus])

object BomUpdate {
  import DateTimeCodecs._

  implicit val BomUpdateCodecJson: CodecJson[BomUpdate] = CodecJson.derive[BomUpdate]
  implicit val BomUpdateDecoder: EntityDecoder[BomUpdate] = jsonOf[BomUpdate]
  implicit val BomUpdateEncoder: EntityEncoder[BomUpdate] = jsonEncoderOf[BomUpdate]
}
