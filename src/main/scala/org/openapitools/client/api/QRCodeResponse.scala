package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import QRCodeResponse._

case class QRCodeResponse (
  `contentType`: String,
qrCodeBase64: String)

object QRCodeResponse {
  import DateTimeCodecs._

  implicit val QRCodeResponseCodecJson: CodecJson[QRCodeResponse] = CodecJson.derive[QRCodeResponse]
  implicit val QRCodeResponseDecoder: EntityDecoder[QRCodeResponse] = jsonOf[QRCodeResponse]
  implicit val QRCodeResponseEncoder: EntityEncoder[QRCodeResponse] = jsonEncoderOf[QRCodeResponse]
}
