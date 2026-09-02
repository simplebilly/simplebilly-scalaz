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

import EmployeeCreate._

case class EmployeeCreate (
  address: Option[String],
/* References another employee who covers when this employee is absent. */
  backupEmployeeId: Option[UUID],
bic: Option[String],
city: Option[String],
country: Option[CountryCode],
dateOfBirth: Option[LocalDate],
/* References the department entity. */
  departmentId: Option[UUID],
email: Option[String],
firstName: Option[String],
/* Gender for pay-transparency reporting: \"male\", \"female\" or \"diverse\". */
  gender: Option[Gender],
hireDate: Option[LocalDate],
/* Hourly cost rate in EUR for labor-cost reporting; when unset the rate is derived from `monthly_salary / (weekly_hours * 4.33)`. */
  hourlyCost: Option[String],
iban: Option[String],
jobTitle: Option[String],
lastLogin: Option[OffsetDateTime],
lastName: Option[String],
lastUpdated: Option[OffsetDateTime],
/* Gross monthly salary in EUR for pay-transparency reporting. */
  monthlySalary: Option[String],
phone: Option[String],
state: Option[String],
status: Option[EmployeeStatus],
/* References the user entity. */
  userId: Option[UUID],
/* Contractual weekly working hours for pay-transparency normalization. */
  weeklyHours: Option[String],
zip: Option[String])

object EmployeeCreate {
  import DateTimeCodecs._

  implicit val EmployeeCreateCodecJson: CodecJson[EmployeeCreate] = CodecJson.derive[EmployeeCreate]
  implicit val EmployeeCreateDecoder: EntityDecoder[EmployeeCreate] = jsonOf[EmployeeCreate]
  implicit val EmployeeCreateEncoder: EntityEncoder[EmployeeCreate] = jsonEncoderOf[EmployeeCreate]
}
