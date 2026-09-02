package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ImportTestResponse._

case class ImportTestResponse (
  error: Option[String],
ok: Boolean)

object ImportTestResponse {
  import DateTimeCodecs._

  implicit val ImportTestResponseCodecJson: CodecJson[ImportTestResponse] = CodecJson.derive[ImportTestResponse]
  implicit val ImportTestResponseDecoder: EntityDecoder[ImportTestResponse] = jsonOf[ImportTestResponse]
  implicit val ImportTestResponseEncoder: EntityEncoder[ImportTestResponse] = jsonEncoderOf[ImportTestResponse]
}
