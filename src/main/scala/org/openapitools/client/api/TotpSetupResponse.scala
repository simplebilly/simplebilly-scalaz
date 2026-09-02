package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TotpSetupResponse._

case class TotpSetupResponse (
  backupCodes: List[String],
qrCodeUrl: String,
secret: String)

object TotpSetupResponse {
  import DateTimeCodecs._

  implicit val TotpSetupResponseCodecJson: CodecJson[TotpSetupResponse] = CodecJson.derive[TotpSetupResponse]
  implicit val TotpSetupResponseDecoder: EntityDecoder[TotpSetupResponse] = jsonOf[TotpSetupResponse]
  implicit val TotpSetupResponseEncoder: EntityEncoder[TotpSetupResponse] = jsonEncoderOf[TotpSetupResponse]
}
