package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID

import TrainingAssignment._

case class TrainingAssignment (
  assignedBy: Option[UUID],
createdAt: Option[OffsetDateTime],
deletedAt: Option[OffsetDateTime],
dueDate: Option[LocalDate],
employeeId: Option[UUID],
id: Option[UUID],
notes: Option[String],
status: Option[AssignmentStatus],
tenantId: Option[UUID],
trainingId: Option[UUID],
updatedAt: Option[OffsetDateTime])

object TrainingAssignment {
  import DateTimeCodecs._

  implicit val TrainingAssignmentCodecJson: CodecJson[TrainingAssignment] = CodecJson.derive[TrainingAssignment]
  implicit val TrainingAssignmentDecoder: EntityDecoder[TrainingAssignment] = jsonOf[TrainingAssignment]
  implicit val TrainingAssignmentEncoder: EntityEncoder[TrainingAssignment] = jsonEncoderOf[TrainingAssignment]
}
