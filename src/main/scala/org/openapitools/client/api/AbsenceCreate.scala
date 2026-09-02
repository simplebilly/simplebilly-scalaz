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

import AbsenceCreate._

case class AbsenceCreate (
  /* One of \"vacation\", \"sick\", \"sabbatical\", \"parental\", \"other\". */
  absenceType: Option[AbsenceType],
approvedAt: Option[OffsetDateTime],
/* References the user entity. */
  approvedBy: Option[UUID],
/* References the employee entity. */
  employeeId: Option[UUID],
endDate: Option[LocalDate],
notes: Option[String],
startDate: Option[LocalDate],
/* One of \"pending\", \"approved\", \"rejected\", \"cancelled\". */
  status: Option[AbsenceStatus])

object AbsenceCreate {
  import DateTimeCodecs._

  implicit val AbsenceCreateCodecJson: CodecJson[AbsenceCreate] = CodecJson.derive[AbsenceCreate]
  implicit val AbsenceCreateDecoder: EntityDecoder[AbsenceCreate] = jsonOf[AbsenceCreate]
  implicit val AbsenceCreateEncoder: EntityEncoder[AbsenceCreate] = jsonEncoderOf[AbsenceCreate]
}
