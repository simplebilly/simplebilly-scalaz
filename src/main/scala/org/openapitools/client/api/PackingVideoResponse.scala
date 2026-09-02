package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PackingVideoResponse._

case class PackingVideoResponse (
  message: String,
recordingUrl: Option[String],
success: Boolean)

object PackingVideoResponse {
  import DateTimeCodecs._

  implicit val PackingVideoResponseCodecJson: CodecJson[PackingVideoResponse] = CodecJson.derive[PackingVideoResponse]
  implicit val PackingVideoResponseDecoder: EntityDecoder[PackingVideoResponse] = jsonOf[PackingVideoResponse]
  implicit val PackingVideoResponseEncoder: EntityEncoder[PackingVideoResponse] = jsonEncoderOf[PackingVideoResponse]
}
