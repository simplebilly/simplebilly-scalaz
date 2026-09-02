package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ImportTestRequest._

case class ImportTestRequest (
  apiKey: String,
provider: String)

object ImportTestRequest {
  import DateTimeCodecs._

  implicit val ImportTestRequestCodecJson: CodecJson[ImportTestRequest] = CodecJson.derive[ImportTestRequest]
  implicit val ImportTestRequestDecoder: EntityDecoder[ImportTestRequest] = jsonOf[ImportTestRequest]
  implicit val ImportTestRequestEncoder: EntityEncoder[ImportTestRequest] = jsonEncoderOf[ImportTestRequest]
}
