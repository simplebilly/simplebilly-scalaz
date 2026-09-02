package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import Job._

case class Job (
  attempts: Option[Integer],
/* Discriminator the worker dispatches on (e.g. \"webhook.deliver\"). */
  jobType: String,
maxAttempts: Integer,
payload: Option[AnyType],
/* Earliest execution time; None = run now. */
  runAt: Option[OffsetDateTime],
/* pending | running | done | failed */
  status: JobStatus)

object Job {
  import DateTimeCodecs._

  implicit val JobCodecJson: CodecJson[Job] = CodecJson.derive[Job]
  implicit val JobDecoder: EntityDecoder[Job] = jsonOf[Job]
  implicit val JobEncoder: EntityEncoder[Job] = jsonEncoderOf[Job]
}
