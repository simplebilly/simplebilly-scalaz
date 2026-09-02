package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import ActivityUpdate._

case class ActivityUpdate (
  /* One of: call | email | meeting | task | note */
  activityType: Option[ActivityType],
/* User responsible (`employee.employee_id`). */
  assignedTo: Option[String],
/* Contact this activity belongs to (`contact.contact_id`). References the contact entity. */
  contactId: Option[String],
description: Option[String],
/* Follow-up / Wiedervorlage date. Open activities with a due date in the past are overdue. */
  dueDate: Option[LocalDate],
/* When to remind about the follow-up. */
  reminderDate: Option[LocalDate],
/* One of: open | done | cancelled */
  status: Option[ActivityStatus],
/* Short subject line. */
  subject: Option[String])

object ActivityUpdate {
  import DateTimeCodecs._

  implicit val ActivityUpdateCodecJson: CodecJson[ActivityUpdate] = CodecJson.derive[ActivityUpdate]
  implicit val ActivityUpdateDecoder: EntityDecoder[ActivityUpdate] = jsonOf[ActivityUpdate]
  implicit val ActivityUpdateEncoder: EntityEncoder[ActivityUpdate] = jsonEncoderOf[ActivityUpdate]
}
