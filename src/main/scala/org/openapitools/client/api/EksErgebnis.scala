package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EksErgebnis._

case class EksErgebnis (
  gesamtergebnis: String,
monate: List[EksMonatsWert],
prognoseNaechste6Monate: String,
summeAusgaben: String,
summeEinnahmen: String,
zeitraumBis: String,
zeitraumVon: String)

object EksErgebnis {
  import DateTimeCodecs._

  implicit val EksErgebnisCodecJson: CodecJson[EksErgebnis] = CodecJson.derive[EksErgebnis]
  implicit val EksErgebnisDecoder: EntityDecoder[EksErgebnis] = jsonOf[EksErgebnis]
  implicit val EksErgebnisEncoder: EntityEncoder[EksErgebnis] = jsonEncoderOf[EksErgebnis]
}
