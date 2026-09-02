package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AnlageSKfzHinweis._

case class AnlageSKfzHinweis (
  bezeichnung: String,
kennzeichen: String,
privatAnteilProzent: String)

object AnlageSKfzHinweis {
  import DateTimeCodecs._

  implicit val AnlageSKfzHinweisCodecJson: CodecJson[AnlageSKfzHinweis] = CodecJson.derive[AnlageSKfzHinweis]
  implicit val AnlageSKfzHinweisDecoder: EntityDecoder[AnlageSKfzHinweis] = jsonOf[AnlageSKfzHinweis]
  implicit val AnlageSKfzHinweisEncoder: EntityEncoder[AnlageSKfzHinweis] = jsonEncoderOf[AnlageSKfzHinweis]
}
