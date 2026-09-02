package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import JahresUstErgebnis._

case class JahresUstErgebnis (
  bis: String,
gespeichertePerioden: Integer,
hatIgTransaktionen: Boolean,
istKleinunternehmer: Boolean,
jahr: Integer,
kz41: String,
kz43: String,
kz46: String,
kz47: String,
kz48: String,
kz61: String,
kz66: String,
kz67: String,
kz81: String,
kz83: String,
kz84: String,
kz85: String,
kz86: String,
kz88: String,
kz89: String,
kz93: String,
restschuld: String,
summeVorauszahlungen: String,
von: String,
zahllast: String)

object JahresUstErgebnis {
  import DateTimeCodecs._

  implicit val JahresUstErgebnisCodecJson: CodecJson[JahresUstErgebnis] = CodecJson.derive[JahresUstErgebnis]
  implicit val JahresUstErgebnisDecoder: EntityDecoder[JahresUstErgebnis] = jsonOf[JahresUstErgebnis]
  implicit val JahresUstErgebnisEncoder: EntityEncoder[JahresUstErgebnis] = jsonEncoderOf[JahresUstErgebnis]
}
