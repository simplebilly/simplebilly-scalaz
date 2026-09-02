package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UstvaErgebnis._

case class UstvaErgebnis (
  bis: String,
hinweis: Option[String],
istKleinunternehmer: Boolean,
kz41: String,
kz43: String,
kz46: String,
kz47: String,
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
von: String,
zahllast: String,
zeitraum: String,
zeitraumTyp: String)

object UstvaErgebnis {
  import DateTimeCodecs._

  implicit val UstvaErgebnisCodecJson: CodecJson[UstvaErgebnis] = CodecJson.derive[UstvaErgebnis]
  implicit val UstvaErgebnisDecoder: EntityDecoder[UstvaErgebnis] = jsonOf[UstvaErgebnis]
  implicit val UstvaErgebnisEncoder: EntityEncoder[UstvaErgebnis] = jsonEncoderOf[UstvaErgebnis]
}
