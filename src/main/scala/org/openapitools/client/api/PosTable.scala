package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PosTable._

case class PosTable (
  currentOrderNumber: Option[String],
name: String,
status: Option[PosTableStatus])

object PosTable {
  import DateTimeCodecs._

  implicit val PosTableCodecJson: CodecJson[PosTable] = CodecJson.derive[PosTable]
  implicit val PosTableDecoder: EntityDecoder[PosTable] = jsonOf[PosTable]
  implicit val PosTableEncoder: EntityEncoder[PosTable] = jsonEncoderOf[PosTable]
}
