package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import XRechnungResponse._

case class XRechnungResponse (
  content: String,
`contentType`: String,
filename: String)

object XRechnungResponse {
  import DateTimeCodecs._

  implicit val XRechnungResponseCodecJson: CodecJson[XRechnungResponse] = CodecJson.derive[XRechnungResponse]
  implicit val XRechnungResponseDecoder: EntityDecoder[XRechnungResponse] = jsonOf[XRechnungResponse]
  implicit val XRechnungResponseEncoder: EntityEncoder[XRechnungResponse] = jsonEncoderOf[XRechnungResponse]
}
