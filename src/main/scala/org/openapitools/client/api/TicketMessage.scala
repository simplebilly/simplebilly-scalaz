package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import TicketMessage._

case class TicketMessage (
  authorEmail: Option[String],
authorName: Option[String],
body: String,
bodyHtml: Option[String],
channelId: Option[UUID],
createdAt: OffsetDateTime,
direction: MessageDirection,
externalId: Option[String],
isInternal: Boolean,
messageType: MessageType,
metadata: AnyType,
tenantId: UUID,
/* References the ticket entity. */
  ticketId: UUID)

object TicketMessage {
  import DateTimeCodecs._

  implicit val TicketMessageCodecJson: CodecJson[TicketMessage] = CodecJson.derive[TicketMessage]
  implicit val TicketMessageDecoder: EntityDecoder[TicketMessage] = jsonOf[TicketMessage]
  implicit val TicketMessageEncoder: EntityEncoder[TicketMessage] = jsonEncoderOf[TicketMessage]
}
