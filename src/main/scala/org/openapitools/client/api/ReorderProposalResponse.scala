package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import ReorderProposalResponse._

case class ReorderProposalResponse (
  generatedAt: OffsetDateTime,
lines: List[ReorderProposalLine],
totalSuggestedQuantity: Long)

object ReorderProposalResponse {
  import DateTimeCodecs._

  implicit val ReorderProposalResponseCodecJson: CodecJson[ReorderProposalResponse] = CodecJson.derive[ReorderProposalResponse]
  implicit val ReorderProposalResponseDecoder: EntityDecoder[ReorderProposalResponse] = jsonOf[ReorderProposalResponse]
  implicit val ReorderProposalResponseEncoder: EntityEncoder[ReorderProposalResponse] = jsonEncoderOf[ReorderProposalResponse]
}
