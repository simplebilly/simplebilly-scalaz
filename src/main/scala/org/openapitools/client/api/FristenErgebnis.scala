package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import FristenErgebnis._

case class FristenErgebnis (
  anzahl: Integer,
fristen: List[FristEintrag])

object FristenErgebnis {
  import DateTimeCodecs._

  implicit val FristenErgebnisCodecJson: CodecJson[FristenErgebnis] = CodecJson.derive[FristenErgebnis]
  implicit val FristenErgebnisDecoder: EntityDecoder[FristenErgebnis] = jsonOf[FristenErgebnis]
  implicit val FristenErgebnisEncoder: EntityEncoder[FristenErgebnis] = jsonEncoderOf[FristenErgebnis]
}
