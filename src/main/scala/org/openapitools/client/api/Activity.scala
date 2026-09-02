package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import Activity._

case class Activity (
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

object Activity {
  import DateTimeCodecs._

  implicit val ActivityCodecJson: CodecJson[Activity] = CodecJson.derive[Activity]
  implicit val ActivityDecoder: EntityDecoder[Activity] = jsonOf[Activity]
  implicit val ActivityEncoder: EntityEncoder[Activity] = jsonEncoderOf[Activity]
}
