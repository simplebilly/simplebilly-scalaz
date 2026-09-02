package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KostenVorschau._

case class KostenVorschau (
  eintraege: List[KostenEintrag],
gesamt: String)

object KostenVorschau {
  import DateTimeCodecs._

  implicit val KostenVorschauCodecJson: CodecJson[KostenVorschau] = CodecJson.derive[KostenVorschau]
  implicit val KostenVorschauDecoder: EntityDecoder[KostenVorschau] = jsonOf[KostenVorschau]
  implicit val KostenVorschauEncoder: EntityEncoder[KostenVorschau] = jsonEncoderOf[KostenVorschau]
}
