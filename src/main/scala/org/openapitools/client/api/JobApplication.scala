package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import JobApplication._

case class JobApplication (
  /* Relative path of the stored CV file under the upload dir. */
  cvFile: Option[String],
/* Extracted CV text, used for match-scoring. */
  cvText: Option[String],
email: Option[String],
matchReason: Option[String],
/* 0-100 LLM match score against the posting's required profile. */
  matchScore: Option[Integer],
name: Option[String],
phone: Option[String],
/* References the job_posting entity. */
  postingId: Option[UUID],
/* website | email | board */
  source: String,
/* new | reviewing | interview | hired | rejected */
  status: ApplicationStatus)

object JobApplication {
  import DateTimeCodecs._

  implicit val JobApplicationCodecJson: CodecJson[JobApplication] = CodecJson.derive[JobApplication]
  implicit val JobApplicationDecoder: EntityDecoder[JobApplication] = jsonOf[JobApplication]
  implicit val JobApplicationEncoder: EntityEncoder[JobApplication] = jsonEncoderOf[JobApplication]
}
