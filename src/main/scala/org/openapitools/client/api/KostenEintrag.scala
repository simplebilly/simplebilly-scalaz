package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KostenEintrag._

case class KostenEintrag (
  beschreibung: String,
betrag: String,
datum: String,
typ: String)

object KostenEintrag {
  import DateTimeCodecs._

  implicit val KostenEintragCodecJson: CodecJson[KostenEintrag] = CodecJson.derive[KostenEintrag]
  implicit val KostenEintragDecoder: EntityDecoder[KostenEintrag] = jsonOf[KostenEintrag]
  implicit val KostenEintragEncoder: EntityEncoder[KostenEintrag] = jsonEncoderOf[KostenEintrag]
}
