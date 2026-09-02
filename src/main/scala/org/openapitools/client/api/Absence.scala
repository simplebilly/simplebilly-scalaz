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

import Absence._

case class Absence (
  /* One of \"vacation\", \"sick\", \"sabbatical\", \"parental\", \"other\". */
  absenceType: Option[AbsenceType],
approvedAt: Option[OffsetDateTime],
/* References the user entity. */
  approvedBy: Option[UUID],
createdAt: Option[OffsetDateTime],
deletedAt: Option[OffsetDateTime],
/* References the employee entity. */
  employeeId: Option[UUID],
endDate: Option[LocalDate],
id: Option[UUID],
notes: Option[String],
startDate: Option[LocalDate],
/* One of \"pending\", \"approved\", \"rejected\", \"cancelled\". */
  status: Option[AbsenceStatus],
tenantId: Option[UUID],
updatedAt: Option[OffsetDateTime])

object Absence {
  import DateTimeCodecs._

  implicit val AbsenceCodecJson: CodecJson[Absence] = CodecJson.derive[Absence]
  implicit val AbsenceDecoder: EntityDecoder[Absence] = jsonOf[Absence]
  implicit val AbsenceEncoder: EntityEncoder[Absence] = jsonEncoderOf[Absence]
}
