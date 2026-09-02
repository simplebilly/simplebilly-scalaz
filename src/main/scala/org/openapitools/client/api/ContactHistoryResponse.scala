package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ContactHistoryResponse._

case class ContactHistoryResponse (
  contactId: String,
inboundCount: Long,
items: List[CustomerCommunication],
outboundCount: Long)

object ContactHistoryResponse {
  import DateTimeCodecs._

  implicit val ContactHistoryResponseCodecJson: CodecJson[ContactHistoryResponse] = CodecJson.derive[ContactHistoryResponse]
  implicit val ContactHistoryResponseDecoder: EntityDecoder[ContactHistoryResponse] = jsonOf[ContactHistoryResponse]
  implicit val ContactHistoryResponseEncoder: EntityEncoder[ContactHistoryResponse] = jsonEncoderOf[ContactHistoryResponse]
}
