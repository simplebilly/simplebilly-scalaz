package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AnlageGKfzHinweis._

case class AnlageGKfzHinweis (
  bezeichnung: String,
kennzeichen: String,
privatAnteilProzent: String)

object AnlageGKfzHinweis {
  import DateTimeCodecs._

  implicit val AnlageGKfzHinweisCodecJson: CodecJson[AnlageGKfzHinweis] = CodecJson.derive[AnlageGKfzHinweis]
  implicit val AnlageGKfzHinweisDecoder: EntityDecoder[AnlageGKfzHinweis] = jsonOf[AnlageGKfzHinweis]
  implicit val AnlageGKfzHinweisEncoder: EntityEncoder[AnlageGKfzHinweis] = jsonEncoderOf[AnlageGKfzHinweis]
}
