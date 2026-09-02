package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import ActivityCreate._

case class ActivityCreate (
  /* One of: call | email | meeting | task | note */
  activityType: ActivityType,
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
  status: ActivityStatus,
/* Short subject line. */
  subject: String)

object ActivityCreate {
  import DateTimeCodecs._

  implicit val ActivityCreateCodecJson: CodecJson[ActivityCreate] = CodecJson.derive[ActivityCreate]
  implicit val ActivityCreateDecoder: EntityDecoder[ActivityCreate] = jsonOf[ActivityCreate]
  implicit val ActivityCreateEncoder: EntityEncoder[ActivityCreate] = jsonEncoderOf[ActivityCreate]
}
