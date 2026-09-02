package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateConnectionRequest._

case class UpdateConnectionRequest (
  apiKey: Option[String],
apiSecret: Option[String],
config: Option[AnyType],
isActive: Option[Boolean],
label: Option[String],
shopDomain: Option[String])

object UpdateConnectionRequest {
  import DateTimeCodecs._

  implicit val UpdateConnectionRequestCodecJson: CodecJson[UpdateConnectionRequest] = CodecJson.derive[UpdateConnectionRequest]
  implicit val UpdateConnectionRequestDecoder: EntityDecoder[UpdateConnectionRequest] = jsonOf[UpdateConnectionRequest]
  implicit val UpdateConnectionRequestEncoder: EntityEncoder[UpdateConnectionRequest] = jsonEncoderOf[UpdateConnectionRequest]
}
