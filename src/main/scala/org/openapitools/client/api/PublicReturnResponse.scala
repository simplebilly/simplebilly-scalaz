package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import PublicReturnResponse._

case class PublicReturnResponse (
  createdAt: OffsetDateTime,
items: AnyType,
notes: Option[String],
orderNumber: Option[String],
returnNumber: String,
returnOrderId: String,
status: String,
updatedAt: Option[OffsetDateTime])

object PublicReturnResponse {
  import DateTimeCodecs._

  implicit val PublicReturnResponseCodecJson: CodecJson[PublicReturnResponse] = CodecJson.derive[PublicReturnResponse]
  implicit val PublicReturnResponseDecoder: EntityDecoder[PublicReturnResponse] = jsonOf[PublicReturnResponse]
  implicit val PublicReturnResponseEncoder: EntityEncoder[PublicReturnResponse] = jsonEncoderOf[PublicReturnResponse]
}
