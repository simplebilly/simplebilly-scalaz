package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import JobPostingUpdate._

case class JobPostingUpdate (
  currency: Option[String],
department: Option[String],
/* What the job is; markdown/HTML. */
  description: Option[String],
/* full_time | part_time | contract | internship | temporary */
  employmentType: Option[EmploymentType],
location: Option[String],
remote: Option[Boolean],
/* List of required skill names (JSON array of strings). */
  requiredSkills: Option[AnyType],
/* Structured profile of the required candidate (skills, experience). */
  requirements: Option[String],
salaryMax: Option[Integer],
salaryMin: Option[Integer],
/* draft | published | closed */
  status: Option[JobPostingStatus],
title: Option[String])

object JobPostingUpdate {
  import DateTimeCodecs._

  implicit val JobPostingUpdateCodecJson: CodecJson[JobPostingUpdate] = CodecJson.derive[JobPostingUpdate]
  implicit val JobPostingUpdateDecoder: EntityDecoder[JobPostingUpdate] = jsonOf[JobPostingUpdate]
  implicit val JobPostingUpdateEncoder: EntityEncoder[JobPostingUpdate] = jsonEncoderOf[JobPostingUpdate]
}
