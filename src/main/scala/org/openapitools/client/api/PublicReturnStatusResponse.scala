package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import PublicReturnStatusResponse._

case class PublicReturnStatusResponse (
  createdAt: OffsetDateTime,
items: AnyType,
notes: Option[String],
orderNumber: Option[String],
returnNumber: String,
returnOrderId: String,
status: String,
updatedAt: Option[OffsetDateTime])

object PublicReturnStatusResponse {
  import DateTimeCodecs._

  implicit val PublicReturnStatusResponseCodecJson: CodecJson[PublicReturnStatusResponse] = CodecJson.derive[PublicReturnStatusResponse]
  implicit val PublicReturnStatusResponseDecoder: EntityDecoder[PublicReturnStatusResponse] = jsonOf[PublicReturnStatusResponse]
  implicit val PublicReturnStatusResponseEncoder: EntityEncoder[PublicReturnStatusResponse] = jsonEncoderOf[PublicReturnStatusResponse]
}
