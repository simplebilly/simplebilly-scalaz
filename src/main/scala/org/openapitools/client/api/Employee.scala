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

import Employee._

case class Employee (
  address: Option[String],
/* References another employee who covers when this employee is absent. */
  backupEmployeeId: Option[UUID],
bic: Option[String],
city: Option[String],
country: Option[CountryCode],
createdAt: Option[OffsetDateTime],
dateOfBirth: Option[LocalDate],
deletedAt: Option[OffsetDateTime],
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
id: Option[UUID],
jobTitle: Option[String],
lastLogin: Option[OffsetDateTime],
lastName: Option[String],
lastUpdated: Option[OffsetDateTime],
/* Gross monthly salary in EUR for pay-transparency reporting. */
  monthlySalary: Option[String],
phone: Option[String],
state: Option[String],
status: Option[EmployeeStatus],
tenantId: Option[UUID],
updatedAt: Option[OffsetDateTime],
/* References the user entity. */
  userId: Option[UUID],
/* Contractual weekly working hours for pay-transparency normalization. */
  weeklyHours: Option[String],
zip: Option[String])

object Employee {
  import DateTimeCodecs._

  implicit val EmployeeCodecJson: CodecJson[Employee] = CodecJson.derive[Employee]
  implicit val EmployeeDecoder: EntityDecoder[Employee] = jsonOf[Employee]
  implicit val EmployeeEncoder: EntityEncoder[Employee] = jsonEncoderOf[Employee]
}
