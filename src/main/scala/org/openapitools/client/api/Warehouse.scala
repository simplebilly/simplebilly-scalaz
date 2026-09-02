package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Warehouse._

case class Warehouse (
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

object Warehouse {
  import DateTimeCodecs._

  implicit val WarehouseCodecJson: CodecJson[Warehouse] = CodecJson.derive[Warehouse]
  implicit val WarehouseDecoder: EntityDecoder[Warehouse] = jsonOf[Warehouse]
  implicit val WarehouseEncoder: EntityEncoder[Warehouse] = jsonEncoderOf[Warehouse]
}
