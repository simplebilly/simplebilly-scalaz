package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import FristEintrag._

case class FristEintrag (
  bezeichnung: String,
faellig: String,
faelligOriginal: String,
hinweis: Option[String],
typ: String,
zeitraum: String)

object FristEintrag {
  import DateTimeCodecs._

  implicit val FristEintragCodecJson: CodecJson[FristEintrag] = CodecJson.derive[FristEintrag]
  implicit val FristEintragDecoder: EntityDecoder[FristEintrag] = jsonOf[FristEintrag]
  implicit val FristEintragEncoder: EntityEncoder[FristEintrag] = jsonEncoderOf[FristEintrag]
}
