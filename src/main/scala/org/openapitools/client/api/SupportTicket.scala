package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import SupportTicket._

case class SupportTicket (
  assignedTo: Option[UUID],
channelId: Option[UUID],
channelType: Option[SupportChannelType],
closedAt: Option[OffsetDateTime],
createdAt: OffsetDateTime,
customerEmail: Option[String],
/* References the customer entity. */
  customerId: Option[String],
customerName: Option[String],
externalId: Option[String],
firstMessageAt: OffsetDateTime,
lastMessageAt: OffsetDateTime,
/* References the lead entity. */
  leadId: Option[UUID],
messageCount: Integer,
orderRef: Option[String],
priority: TicketPriority,
resolution: Option[String],
status: SupportTicketStatus,
subject: String,
tags: AnyType,
tenantId: UUID,
updatedAt: Option[OffsetDateTime])

object SupportTicket {
  import DateTimeCodecs._

  implicit val SupportTicketCodecJson: CodecJson[SupportTicket] = CodecJson.derive[SupportTicket]
  implicit val SupportTicketDecoder: EntityDecoder[SupportTicket] = jsonOf[SupportTicket]
  implicit val SupportTicketEncoder: EntityEncoder[SupportTicket] = jsonEncoderOf[SupportTicket]
}
