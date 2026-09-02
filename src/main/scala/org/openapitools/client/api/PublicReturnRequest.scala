package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PublicReturnRequest._

case class PublicReturnRequest (
  email: String,
items: List[PublicReturnItem],
notes: Option[String],
orderNumber: String)

object PublicReturnRequest {
  import DateTimeCodecs._

  implicit val PublicReturnRequestCodecJson: CodecJson[PublicReturnRequest] = CodecJson.derive[PublicReturnRequest]
  implicit val PublicReturnRequestDecoder: EntityDecoder[PublicReturnRequest] = jsonOf[PublicReturnRequest]
  implicit val PublicReturnRequestEncoder: EntityEncoder[PublicReturnRequest] = jsonEncoderOf[PublicReturnRequest]
}
