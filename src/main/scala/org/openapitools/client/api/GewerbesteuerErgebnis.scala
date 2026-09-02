package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GewerbesteuerErgebnis._

case class GewerbesteuerErgebnis (
  freibetrag: String,
gesamtbelastung: String,
gewerbeertrag: String,
hebesatz: String,
jahr: Integer,
koerperschaftsteuer: String,
land: String,
messbetrag: String,
steuer: String,
steuerArt: String)

object GewerbesteuerErgebnis {
  import DateTimeCodecs._

  implicit val GewerbesteuerErgebnisCodecJson: CodecJson[GewerbesteuerErgebnis] = CodecJson.derive[GewerbesteuerErgebnis]
  implicit val GewerbesteuerErgebnisDecoder: EntityDecoder[GewerbesteuerErgebnis] = jsonOf[GewerbesteuerErgebnis]
  implicit val GewerbesteuerErgebnisEncoder: EntityEncoder[GewerbesteuerErgebnis] = jsonEncoderOf[GewerbesteuerErgebnis]
}
