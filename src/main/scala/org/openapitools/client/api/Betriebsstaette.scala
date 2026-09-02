package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import Betriebsstaette._

case class Betriebsstaette (
  beschaefigte: Long,
name: String)

object Betriebsstaette {
  import DateTimeCodecs._

  implicit val BetriebsstaetteCodecJson: CodecJson[Betriebsstaette] = CodecJson.derive[Betriebsstaette]
  implicit val BetriebsstaetteDecoder: EntityDecoder[Betriebsstaette] = jsonOf[Betriebsstaette]
  implicit val BetriebsstaetteEncoder: EntityEncoder[Betriebsstaette] = jsonEncoderOf[Betriebsstaette]
}
