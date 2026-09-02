package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GewinnverwendungsZeile._

case class GewinnverwendungsZeile (
  /* Betrag in EUR (2 Nachkommastellen, als String formatiert). */
  betrag: String,
/* Deutsche Bezeichnung der Zeile. */
  label: String)

object GewinnverwendungsZeile {
  import DateTimeCodecs._

  implicit val GewinnverwendungsZeileCodecJson: CodecJson[GewinnverwendungsZeile] = CodecJson.derive[GewinnverwendungsZeile]
  implicit val GewinnverwendungsZeileDecoder: EntityDecoder[GewinnverwendungsZeile] = jsonOf[GewinnverwendungsZeile]
  implicit val GewinnverwendungsZeileEncoder: EntityEncoder[GewinnverwendungsZeile] = jsonEncoderOf[GewinnverwendungsZeile]
}
