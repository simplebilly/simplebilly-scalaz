package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EksMonatsWert._

case class EksMonatsWert (
  ausgaben: String,
einnahmen: String,
ergebnis: String,
monat: String)

object EksMonatsWert {
  import DateTimeCodecs._

  implicit val EksMonatsWertCodecJson: CodecJson[EksMonatsWert] = CodecJson.derive[EksMonatsWert]
  implicit val EksMonatsWertDecoder: EntityDecoder[EksMonatsWert] = jsonOf[EksMonatsWert]
  implicit val EksMonatsWertEncoder: EntityEncoder[EksMonatsWert] = jsonEncoderOf[EksMonatsWert]
}
