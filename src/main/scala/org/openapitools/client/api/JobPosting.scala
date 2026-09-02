package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import JobPosting._

case class JobPosting (
  currency: Option[String],
department: Option[String],
/* What the job is; markdown/HTML. */
  description: String,
/* full_time | part_time | contract | internship | temporary */
  employmentType: Option[EmploymentType],
location: Option[String],
remote: Boolean,
/* List of required skill names (JSON array of strings). */
  requiredSkills: AnyType,
/* Structured profile of the required candidate (skills, experience). */
  requirements: Option[String],
salaryMax: Option[Integer],
salaryMin: Option[Integer],
/* draft | published | closed */
  status: JobPostingStatus,
title: String)

object JobPosting {
  import DateTimeCodecs._

  implicit val JobPostingCodecJson: CodecJson[JobPosting] = CodecJson.derive[JobPosting]
  implicit val JobPostingDecoder: EntityDecoder[JobPosting] = jsonOf[JobPosting]
  implicit val JobPostingEncoder: EntityEncoder[JobPosting] = jsonEncoderOf[JobPosting]
}
