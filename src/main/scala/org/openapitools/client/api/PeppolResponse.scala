package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PeppolResponse._

case class PeppolResponse (
  content: String,
`contentType`: String,
filename: String)

object PeppolResponse {
  import DateTimeCodecs._

  implicit val PeppolResponseCodecJson: CodecJson[PeppolResponse] = CodecJson.derive[PeppolResponse]
  implicit val PeppolResponseDecoder: EntityDecoder[PeppolResponse] = jsonOf[PeppolResponse]
  implicit val PeppolResponseEncoder: EntityEncoder[PeppolResponse] = jsonEncoderOf[PeppolResponse]
}
