package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PosTableCreate._

case class PosTableCreate (
  currentOrderNumber: Option[String],
name: String,
status: Option[PosTableStatus])

object PosTableCreate {
  import DateTimeCodecs._

  implicit val PosTableCreateCodecJson: CodecJson[PosTableCreate] = CodecJson.derive[PosTableCreate]
  implicit val PosTableCreateDecoder: EntityDecoder[PosTableCreate] = jsonOf[PosTableCreate]
  implicit val PosTableCreateEncoder: EntityEncoder[PosTableCreate] = jsonEncoderOf[PosTableCreate]
}
