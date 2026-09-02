package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PackingCompleteResponse._

case class PackingCompleteResponse (
  message: String,
newState: String,
orderNumber: String,
success: Boolean)

object PackingCompleteResponse {
  import DateTimeCodecs._

  implicit val PackingCompleteResponseCodecJson: CodecJson[PackingCompleteResponse] = CodecJson.derive[PackingCompleteResponse]
  implicit val PackingCompleteResponseDecoder: EntityDecoder[PackingCompleteResponse] = jsonOf[PackingCompleteResponse]
  implicit val PackingCompleteResponseEncoder: EntityEncoder[PackingCompleteResponse] = jsonEncoderOf[PackingCompleteResponse]
}
