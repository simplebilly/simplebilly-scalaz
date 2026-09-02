package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KstErgebnis._

case class KstErgebnis (
  gesamt: String,
gesamtbelastung: String,
gewerbesteuer: String,
gewinn: String,
istKapitalgesellschaft: Boolean,
jahr: Integer,
koerperschaftsteuer: String,
solidaritaetszuschlag: String)

object KstErgebnis {
  import DateTimeCodecs._

  implicit val KstErgebnisCodecJson: CodecJson[KstErgebnis] = CodecJson.derive[KstErgebnis]
  implicit val KstErgebnisDecoder: EntityDecoder[KstErgebnis] = jsonOf[KstErgebnis]
  implicit val KstErgebnisEncoder: EntityEncoder[KstErgebnis] = jsonEncoderOf[KstErgebnis]
}
