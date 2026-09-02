package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import LaborCostRow._

case class LaborCostRow (
  cost: String,
employeeId: Option[UUID],
groupKey: String,
hours: String,
name: Option[String])

object LaborCostRow {
  import DateTimeCodecs._

  implicit val LaborCostRowCodecJson: CodecJson[LaborCostRow] = CodecJson.derive[LaborCostRow]
  implicit val LaborCostRowDecoder: EntityDecoder[LaborCostRow] = jsonOf[LaborCostRow]
  implicit val LaborCostRowEncoder: EntityEncoder[LaborCostRow] = jsonEncoderOf[LaborCostRow]
}
