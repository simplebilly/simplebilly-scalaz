package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BetriebsstaettenDetail._

case class BetriebsstaettenDetail (
  beschaefigte: Long,
monatlicherBeitrag: String,
name: String)

object BetriebsstaettenDetail {
  import DateTimeCodecs._

  implicit val BetriebsstaettenDetailCodecJson: CodecJson[BetriebsstaettenDetail] = CodecJson.derive[BetriebsstaettenDetail]
  implicit val BetriebsstaettenDetailDecoder: EntityDecoder[BetriebsstaettenDetail] = jsonOf[BetriebsstaettenDetail]
  implicit val BetriebsstaettenDetailEncoder: EntityEncoder[BetriebsstaettenDetail] = jsonEncoderOf[BetriebsstaettenDetail]
}
