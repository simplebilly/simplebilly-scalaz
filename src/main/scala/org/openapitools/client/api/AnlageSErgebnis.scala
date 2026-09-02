package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AnlageSErgebnis._

case class AnlageSErgebnis (
  gewinnVerlust: String,
jahr: Integer,
kfzHinweise: List[AnlageSKfzHinweis])

object AnlageSErgebnis {
  import DateTimeCodecs._

  implicit val AnlageSErgebnisCodecJson: CodecJson[AnlageSErgebnis] = CodecJson.derive[AnlageSErgebnis]
  implicit val AnlageSErgebnisDecoder: EntityDecoder[AnlageSErgebnis] = jsonOf[AnlageSErgebnis]
  implicit val AnlageSErgebnisEncoder: EntityEncoder[AnlageSErgebnis] = jsonEncoderOf[AnlageSErgebnis]
}
