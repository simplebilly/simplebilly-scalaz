package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.util.UUID

import ServiceAssignment._

case class ServiceAssignment (
  /* References the employees entity. */
  employeeId: Option[UUID],
/* References the service_jobs entity. */
  jobId: Option[UUID],
notes: Option[String],
/* Work day the assignment is scheduled for. */
  scheduledDate: Option[LocalDate],
/* Planned end time of the assignment. */
  scheduledEnd: Option[String],
/* Planned start time of the assignment. */
  scheduledStart: Option[String],
/* Assignment lifecycle status: \"planned\", \"confirmed\", \"en_route\", \"in_progress\", \"completed\" or \"cancelled\". */
  status: Option[ServiceAssignmentStatus])

object ServiceAssignment {
  import DateTimeCodecs._

  implicit val ServiceAssignmentCodecJson: CodecJson[ServiceAssignment] = CodecJson.derive[ServiceAssignment]
  implicit val ServiceAssignmentDecoder: EntityDecoder[ServiceAssignment] = jsonOf[ServiceAssignment]
  implicit val ServiceAssignmentEncoder: EntityEncoder[ServiceAssignment] = jsonEncoderOf[ServiceAssignment]
}
