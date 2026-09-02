package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.util.UUID

import TrainingAssignmentUpdate._

case class TrainingAssignmentUpdate (
  assignedBy: Option[UUID],
dueDate: Option[LocalDate],
employeeId: Option[UUID],
notes: Option[String],
status: Option[AssignmentStatus],
trainingId: Option[UUID])

object TrainingAssignmentUpdate {
  import DateTimeCodecs._

  implicit val TrainingAssignmentUpdateCodecJson: CodecJson[TrainingAssignmentUpdate] = CodecJson.derive[TrainingAssignmentUpdate]
  implicit val TrainingAssignmentUpdateDecoder: EntityDecoder[TrainingAssignmentUpdate] = jsonOf[TrainingAssignmentUpdate]
  implicit val TrainingAssignmentUpdateEncoder: EntityEncoder[TrainingAssignmentUpdate] = jsonEncoderOf[TrainingAssignmentUpdate]
}
