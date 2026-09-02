package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ImportStartRequest._

case class ImportStartRequest (
  apiKey: String,
provider: String,
years: List[Integer])

object ImportStartRequest {
  import DateTimeCodecs._

  implicit val ImportStartRequestCodecJson: CodecJson[ImportStartRequest] = CodecJson.derive[ImportStartRequest]
  implicit val ImportStartRequestDecoder: EntityDecoder[ImportStartRequest] = jsonOf[ImportStartRequest]
  implicit val ImportStartRequestEncoder: EntityEncoder[ImportStartRequest] = jsonEncoderOf[ImportStartRequest]
}
