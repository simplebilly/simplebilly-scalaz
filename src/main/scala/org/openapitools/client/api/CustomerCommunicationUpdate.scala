package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import CustomerCommunicationUpdate._

case class CustomerCommunicationUpdate (
  /* The message body, call summary or note text. */
  body: Option[String],
channel: Option[CommunicationChannel],
/* The contact (customer/supplier) this communication belongs to. References the contact entity. */
  contactId: Option[String],
/* Email/phone of the counterparty, if applicable. */
  counterparty: Option[String],
direction: Option[CommunicationDirection],
/* When the communication happened (defaults to now on create). */
  occurredAt: Option[OffsetDateTime],
subject: Option[String],
/* Free-form tags, e.g. `[\"follow-up-required\"]`. */
  tags: Option[AnyType])

object CustomerCommunicationUpdate {
  import DateTimeCodecs._

  implicit val CustomerCommunicationUpdateCodecJson: CodecJson[CustomerCommunicationUpdate] = CodecJson.derive[CustomerCommunicationUpdate]
  implicit val CustomerCommunicationUpdateDecoder: EntityDecoder[CustomerCommunicationUpdate] = jsonOf[CustomerCommunicationUpdate]
  implicit val CustomerCommunicationUpdateEncoder: EntityEncoder[CustomerCommunicationUpdate] = jsonEncoderOf[CustomerCommunicationUpdate]
}
