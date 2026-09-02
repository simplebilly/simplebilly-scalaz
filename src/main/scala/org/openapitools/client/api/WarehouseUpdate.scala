package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import WarehouseUpdate._

case class WarehouseUpdate (
  addressCity: Option[String],
addressCountry: Option[CountryCode],
addressStreet: Option[String],
addressZip: Option[String],
/* JSON array of bin locations, e.g. `[\"A-01-01\", \"A-01-02\"]`. */
  binLocations: Option[AnyType],
code: Option[String],
isActive: Option[Boolean],
isDefault: Option[Boolean],
name: Option[String],
notes: Option[String])

object WarehouseUpdate {
  import DateTimeCodecs._

  implicit val WarehouseUpdateCodecJson: CodecJson[WarehouseUpdate] = CodecJson.derive[WarehouseUpdate]
  implicit val WarehouseUpdateDecoder: EntityDecoder[WarehouseUpdate] = jsonOf[WarehouseUpdate]
  implicit val WarehouseUpdateEncoder: EntityEncoder[WarehouseUpdate] = jsonEncoderOf[WarehouseUpdate]
}
