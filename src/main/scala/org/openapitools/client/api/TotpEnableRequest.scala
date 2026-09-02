package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TotpEnableRequest._

case class TotpEnableRequest (
  code: String)

object TotpEnableRequest {
  import DateTimeCodecs._

  implicit val TotpEnableRequestCodecJson: CodecJson[TotpEnableRequest] = CodecJson.derive[TotpEnableRequest]
  implicit val TotpEnableRequestDecoder: EntityDecoder[TotpEnableRequest] = jsonOf[TotpEnableRequest]
  implicit val TotpEnableRequestEncoder: EntityEncoder[TotpEnableRequest] = jsonEncoderOf[TotpEnableRequest]
}
