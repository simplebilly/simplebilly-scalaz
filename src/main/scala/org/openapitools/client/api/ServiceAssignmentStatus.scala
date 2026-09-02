package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ServiceAssignmentStatus._

case class ServiceAssignmentStatus (
  
object ServiceAssignmentStatus {
  import DateTimeCodecs._

  implicit val ServiceAssignmentStatusCodecJson: CodecJson[ServiceAssignmentStatus] = CodecJson.derive[ServiceAssignmentStatus]
  implicit val ServiceAssignmentStatusDecoder: EntityDecoder[ServiceAssignmentStatus] = jsonOf[ServiceAssignmentStatus]
  implicit val ServiceAssignmentStatusEncoder: EntityEncoder[ServiceAssignmentStatus] = jsonEncoderOf[ServiceAssignmentStatus]
}
