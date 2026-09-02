package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import JobPostingFilter._

case class JobPostingFilter (
  page: Option[Integer],
pageSize: Option[Integer],
status: Option[String])

object JobPostingFilter {
  import DateTimeCodecs._

  implicit val JobPostingFilterCodecJson: CodecJson[JobPostingFilter] = CodecJson.derive[JobPostingFilter]
  implicit val JobPostingFilterDecoder: EntityDecoder[JobPostingFilter] = jsonOf[JobPostingFilter]
  implicit val JobPostingFilterEncoder: EntityEncoder[JobPostingFilter] = jsonEncoderOf[JobPostingFilter]
}
