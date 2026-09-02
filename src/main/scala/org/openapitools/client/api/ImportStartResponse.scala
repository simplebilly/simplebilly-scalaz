package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ImportStartResponse._

case class ImportStartResponse (
  jobId: String)

object ImportStartResponse {
  import DateTimeCodecs._

  implicit val ImportStartResponseCodecJson: CodecJson[ImportStartResponse] = CodecJson.derive[ImportStartResponse]
  implicit val ImportStartResponseDecoder: EntityDecoder[ImportStartResponse] = jsonOf[ImportStartResponse]
  implicit val ImportStartResponseEncoder: EntityEncoder[ImportStartResponse] = jsonEncoderOf[ImportStartResponse]
}
