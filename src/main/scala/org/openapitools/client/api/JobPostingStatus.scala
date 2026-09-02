package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import JobPostingStatus._

case class JobPostingStatus (
  
object JobPostingStatus {
  import DateTimeCodecs._

  implicit val JobPostingStatusCodecJson: CodecJson[JobPostingStatus] = CodecJson.derive[JobPostingStatus]
  implicit val JobPostingStatusDecoder: EntityDecoder[JobPostingStatus] = jsonOf[JobPostingStatus]
  implicit val JobPostingStatusEncoder: EntityEncoder[JobPostingStatus] = jsonEncoderOf[JobPostingStatus]
}
