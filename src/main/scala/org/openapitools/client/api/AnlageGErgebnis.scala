package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AnlageGErgebnis._

case class AnlageGErgebnis (
  gewinnVerlust: String,
gewstGezahlt: String,
gewstMessbetragApprox: String,
gewstPflichtig: Boolean,
jahr: Integer,
kfzHinweise: List[AnlageGKfzHinweis])

object AnlageGErgebnis {
  import DateTimeCodecs._

  implicit val AnlageGErgebnisCodecJson: CodecJson[AnlageGErgebnis] = CodecJson.derive[AnlageGErgebnis]
  implicit val AnlageGErgebnisDecoder: EntityDecoder[AnlageGErgebnis] = jsonOf[AnlageGErgebnis]
  implicit val AnlageGErgebnisEncoder: EntityEncoder[AnlageGErgebnis] = jsonEncoderOf[AnlageGErgebnis]
}
