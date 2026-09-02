package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.util.UUID

import TrainingAssignmentCreate._

case class TrainingAssignmentCreate (
  assignedBy: Option[UUID],
dueDate: Option[LocalDate],
employeeId: Option[UUID],
notes: Option[String],
status: Option[AssignmentStatus],
trainingId: Option[UUID])

object TrainingAssignmentCreate {
  import DateTimeCodecs._

  implicit val TrainingAssignmentCreateCodecJson: CodecJson[TrainingAssignmentCreate] = CodecJson.derive[TrainingAssignmentCreate]
  implicit val TrainingAssignmentCreateDecoder: EntityDecoder[TrainingAssignmentCreate] = jsonOf[TrainingAssignmentCreate]
  implicit val TrainingAssignmentCreateEncoder: EntityEncoder[TrainingAssignmentCreate] = jsonEncoderOf[TrainingAssignmentCreate]
}
