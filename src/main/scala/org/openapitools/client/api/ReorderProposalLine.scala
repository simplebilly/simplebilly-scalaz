package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ReorderProposalLine._

case class ReorderProposalLine (
  currentStock: Long,
maxStock: Option[Long],
minStock: Option[Long],
productId: UUID,
productName: String,
reorderQuantity: Option[Long],
sku: String,
suggestedQuantity: Long)

object ReorderProposalLine {
  import DateTimeCodecs._

  implicit val ReorderProposalLineCodecJson: CodecJson[ReorderProposalLine] = CodecJson.derive[ReorderProposalLine]
  implicit val ReorderProposalLineDecoder: EntityDecoder[ReorderProposalLine] = jsonOf[ReorderProposalLine]
  implicit val ReorderProposalLineEncoder: EntityEncoder[ReorderProposalLine] = jsonEncoderOf[ReorderProposalLine]
}
