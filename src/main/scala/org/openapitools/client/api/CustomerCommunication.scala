package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import CustomerCommunication._

case class CustomerCommunication (
  /* The message body, call summary or note text. */
  body: Option[String],
channel: CommunicationChannel,
/* The contact (customer/supplier) this communication belongs to. References the contact entity. */
  contactId: String,
/* Email/phone of the counterparty, if applicable. */
  counterparty: Option[String],
direction: CommunicationDirection,
/* When the communication happened (defaults to now on create). */
  occurredAt: Option[OffsetDateTime],
subject: Option[String],
/* Free-form tags, e.g. `[\"follow-up-required\"]`. */
  tags: Option[AnyType])

object CustomerCommunication {
  import DateTimeCodecs._

  implicit val CustomerCommunicationCodecJson: CodecJson[CustomerCommunication] = CodecJson.derive[CustomerCommunication]
  implicit val CustomerCommunicationDecoder: EntityDecoder[CustomerCommunication] = jsonOf[CustomerCommunication]
  implicit val CustomerCommunicationEncoder: EntityEncoder[CustomerCommunication] = jsonEncoderOf[CustomerCommunication]
}
