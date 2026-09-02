package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AssignmentStatus._

case class AssignmentStatus (
  
object AssignmentStatus {
  import DateTimeCodecs._

  implicit val AssignmentStatusCodecJson: CodecJson[AssignmentStatus] = CodecJson.derive[AssignmentStatus]
  implicit val AssignmentStatusDecoder: EntityDecoder[AssignmentStatus] = jsonOf[AssignmentStatus]
  implicit val AssignmentStatusEncoder: EntityEncoder[AssignmentStatus] = jsonEncoderOf[AssignmentStatus]
}
