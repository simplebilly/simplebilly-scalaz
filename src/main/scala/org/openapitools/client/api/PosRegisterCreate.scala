package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PosRegisterCreate._

case class PosRegisterCreate (
  name: String,
status: Option[PosRegisterStatus])

object PosRegisterCreate {
  import DateTimeCodecs._

  implicit val PosRegisterCreateCodecJson: CodecJson[PosRegisterCreate] = CodecJson.derive[PosRegisterCreate]
  implicit val PosRegisterCreateDecoder: EntityDecoder[PosRegisterCreate] = jsonOf[PosRegisterCreate]
  implicit val PosRegisterCreateEncoder: EntityEncoder[PosRegisterCreate] = jsonEncoderOf[PosRegisterCreate]
}
