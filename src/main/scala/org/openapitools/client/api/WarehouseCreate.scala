package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WarehouseCreate._

case class WarehouseCreate (
  addressCity: Option[String],
addressCountry: Option[CountryCode],
addressStreet: Option[String],
addressZip: Option[String],
/* JSON array of bin locations, e.g. `[\"A-01-01\", \"A-01-02\"]`. */
  binLocations: Option[AnyType],
code: String,
isActive: Option[Boolean],
isDefault: Option[Boolean],
name: String,
notes: Option[String])

object WarehouseCreate {
  import DateTimeCodecs._

  implicit val WarehouseCreateCodecJson: CodecJson[WarehouseCreate] = CodecJson.derive[WarehouseCreate]
  implicit val WarehouseCreateDecoder: EntityDecoder[WarehouseCreate] = jsonOf[WarehouseCreate]
  implicit val WarehouseCreateEncoder: EntityEncoder[WarehouseCreate] = jsonEncoderOf[WarehouseCreate]
}
