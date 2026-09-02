package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import CreateTicketRequest._

case class CreateTicketRequest (
  channelId: Option[UUID],
channelType: Option[String],
customerEmail: Option[String],
customerId: Option[String],
customerName: Option[String],
externalId: Option[String],
messageBody: String,
orderRef: Option[String],
subject: String)

object CreateTicketRequest {
  import DateTimeCodecs._

  implicit val CreateTicketRequestCodecJson: CodecJson[CreateTicketRequest] = CodecJson.derive[CreateTicketRequest]
  implicit val CreateTicketRequestDecoder: EntityDecoder[CreateTicketRequest] = jsonOf[CreateTicketRequest]
  implicit val CreateTicketRequestEncoder: EntityEncoder[CreateTicketRequest] = jsonEncoderOf[CreateTicketRequest]
}
