package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EuerErgebnis._

case class EuerErgebnis (
  anlageZugaenge: String,
gewinnVerlust: String,
jahr: Integer,
summeAusgaben: String,
summeEinnahmen: String,
zeilen: List[EuerZeile])

object EuerErgebnis {
  import DateTimeCodecs._

  implicit val EuerErgebnisCodecJson: CodecJson[EuerErgebnis] = CodecJson.derive[EuerErgebnis]
  implicit val EuerErgebnisDecoder: EntityDecoder[EuerErgebnis] = jsonOf[EuerErgebnis]
  implicit val EuerErgebnisEncoder: EntityEncoder[EuerErgebnis] = jsonEncoderOf[EuerErgebnis]
}
