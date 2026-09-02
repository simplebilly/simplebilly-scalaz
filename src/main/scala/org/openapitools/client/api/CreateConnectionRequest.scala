package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CreateConnectionRequest._

case class CreateConnectionRequest (
  apiKey: Option[String],
apiSecret: Option[String],
config: Option[AnyType],
label: String,
platform: String,
shopDomain: Option[String])

object CreateConnectionRequest {
  import DateTimeCodecs._

  implicit val CreateConnectionRequestCodecJson: CodecJson[CreateConnectionRequest] = CodecJson.derive[CreateConnectionRequest]
  implicit val CreateConnectionRequestDecoder: EntityDecoder[CreateConnectionRequest] = jsonOf[CreateConnectionRequest]
  implicit val CreateConnectionRequestEncoder: EntityEncoder[CreateConnectionRequest] = jsonEncoderOf[CreateConnectionRequest]
}
