package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ImportJobStatus._

case class ImportJobStatus (
  /* Set only when the job failed. */
  error: Option[String],
jobId: String,
processed: Long,
/* 0–100 */
  progress: Integer,
/* Which competitor the import came from (lexoffice | billbee); the frontend uses it to label the job. Absent for legacy jobs. */
  provider: Option[String],
/* queued | fetching | downloading | importing | done */
  stage: String,
/* pending | running | done | failed */
  status: String,
total: Long)

object ImportJobStatus {
  import DateTimeCodecs._

  implicit val ImportJobStatusCodecJson: CodecJson[ImportJobStatus] = CodecJson.derive[ImportJobStatus]
  implicit val ImportJobStatusDecoder: EntityDecoder[ImportJobStatus] = jsonOf[ImportJobStatus]
  implicit val ImportJobStatusEncoder: EntityEncoder[ImportJobStatus] = jsonEncoderOf[ImportJobStatus]
}
