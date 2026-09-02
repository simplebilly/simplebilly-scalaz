package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EuerDetailErgebnis._

case class EuerDetailErgebnis (
  jahr: Integer,
zeilen: List[EuerZeileDetail])

object EuerDetailErgebnis {
  import DateTimeCodecs._

  implicit val EuerDetailErgebnisCodecJson: CodecJson[EuerDetailErgebnis] = CodecJson.derive[EuerDetailErgebnis]
  implicit val EuerDetailErgebnisDecoder: EntityDecoder[EuerDetailErgebnis] = jsonOf[EuerDetailErgebnis]
  implicit val EuerDetailErgebnisEncoder: EntityEncoder[EuerDetailErgebnis] = jsonEncoderOf[EuerDetailErgebnis]
}
