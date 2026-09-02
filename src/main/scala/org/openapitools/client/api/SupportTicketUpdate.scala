package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import SupportTicketUpdate._

case class SupportTicketUpdate (
  assignedTo: Option[UUID],
channelId: Option[UUID],
channelType: Option[SupportChannelType],
closedAt: Option[OffsetDateTime],
createdAt: Option[OffsetDateTime],
customerEmail: Option[String],
/* References the customer entity. */
  customerId: Option[String],
customerName: Option[String],
externalId: Option[String],
firstMessageAt: Option[OffsetDateTime],
lastMessageAt: Option[OffsetDateTime],
/* References the lead entity. */
  leadId: Option[UUID],
messageCount: Option[Integer],
orderRef: Option[String],
priority: Option[TicketPriority],
resolution: Option[String],
status: Option[SupportTicketStatus],
subject: Option[String],
tags: Option[AnyType],
tenantId: Option[UUID],
updatedAt: Option[OffsetDateTime])

object SupportTicketUpdate {
  import DateTimeCodecs._

  implicit val SupportTicketUpdateCodecJson: CodecJson[SupportTicketUpdate] = CodecJson.derive[SupportTicketUpdate]
  implicit val SupportTicketUpdateDecoder: EntityDecoder[SupportTicketUpdate] = jsonOf[SupportTicketUpdate]
  implicit val SupportTicketUpdateEncoder: EntityEncoder[SupportTicketUpdate] = jsonEncoderOf[SupportTicketUpdate]
}
